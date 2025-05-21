import json
import subprocess
import shutil
import logging
import time
from pathlib import Path
from typing import List, Dict, Any, Tuple, Optional, Union

import ollama

# -----------------------------------------------------------------------------
# Time limit configuration
# -----------------------------------------------------------------------------
TIME_LIMIT_SECONDS = 60 * 60 * 2
START_TIME = None  # will be set at generation start

# -----------------------------------------------------------------------------
# Configuration
# -----------------------------------------------------------------------------
MAX_UNIT_BUDGET = 5
MAX_COV_BUDGET = 10
MAX_COV_TESTS = 3

# -----------------------------------------------------------------------------
# Logging setup
# -----------------------------------------------------------------------------
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s"
)
logger = logging.getLogger(__name__)

# -----------------------------------------------------------------------------
# Branch ordering helper
# -----------------------------------------------------------------------------
def order_branches(branches: List[Dict[str, Any]]) -> List[Dict[str, int]]:
    seen = set()
    unique = []
    for b in branches:
        s = b['start']['line']
        e = b['end']['line']
        if (s, e) not in seen:
            seen.add((s, e))
            unique.append(b)

    enriched = []
    for b in unique:
        s = b['start']['line']
        e = b['end']['line']
        depth = sum(1 for o in unique if o['start']['line'] < s and o['end']['line'] > e)
        length = e - s
        enriched.append({**b, '_depth': depth, '_length': length})

    enriched.sort(key=lambda x: (x['_depth'], x['_length']), reverse=True)
    return [{'start': b['start']['line'], 'end': b['end']['line']} for b in enriched]

def build_unit_prompt(
    mut_source: str,
    mut_name: str,
    proj_name: str,
    pkg_name: str
) -> str:
    header = f"source code of {mut_name}:\n```javascript\n{mut_source}\n```\n\n"
    template = (
        f"Please write a unit test for {mut_name} api:\n"
        "```javascript\n"
        "let mocha = require('mocha');\n"
        "let assert = require('assert');\n"
        f"let {pkg_name} = require('{proj_name}');\n\n"
        f"describe(test '{proj_name}', function() {{\n"
        f"    it('test {mut_name}', function() {{\n"
        "        // ...\n"
        "    });\n"
        "});\n```\n\n"
        f"You must import package with `let {pkg_name} = require('{proj_name}');`. Use package name, do NOT use relative directory.\n"
        "You must write a simple & self-contained `it` test case.\n"
        "I will run your test directly, so give only the test as answer."
    )
    return header + template


def build_branch_prompt(
    mut_source: str,
    mut_name: str,
    proj_name: str,
    pkg_name: str,
    br,
    loc: Dict[str, Any]
) -> str:

    template = (
        f"Please write a test for the uncovered branch in {mut_name} api:\n"
        "```javascript\n"
        "let mocha = require('mocha');\n"
        "let assert = require('assert');\n"
        f"let {pkg_name} = require('{proj_name}');\n\n"
        f"describe('test {proj_name}', function() {{\n"
        f"    it('uncovered branch in {mut_name}', function() {{\n"
        "        // ...\n"
        "    });\n"
        "});\n```\n\n"
         f"You must import package with `let {pkg_name} = require('{proj_name}');`. Use package name, do NOT use relative directory.\n"
        "You must write a simple `it` test case that triggers the uncovered branch.\n"
        "I will run your test directly, so give only the test as answer."
    )

    lines = mut_source.split("\n")
    start_line = br["start"]
    end_line = br["end"]
    rel_start = start_line - loc["startLine"]
    rel_end = end_line - loc["startLine"]

    if rel_start == rel_end:
        lines.insert(rel_start, "    // branch not covered")
    else:
        lines.insert(rel_end + 1, "    // */")
        lines.insert(rel_start, "    // branch not covered\n    // /*")

    annot_source = "\n".join(lines)
    header = f"source code of {mut_name}:\n```javascript\n{annot_source}\n```\n\n"

    return header + template

# -----------------------------------------------------------------------------
# LLM generate
# -----------------------------------------------------------------------------
def llm_generate(
    prompt: str
) -> str:

    res = ollama.chat(model='qwen2.5:72b', messages=[{'role': 'user', 'content': prompt}])
    return res.message.content

# -----------------------------------------------------------------------------
# Test / coverage execution helper
# -----------------------------------------------------------------------------
def run_test(
    project_root: Path,
    test_paths: Optional[Union[Path, List[Path]]],
    test_cmd: str,
) -> Dict[str, Any]:
    """
    Execute `npm run <test_cmd> [test_paths…]`
    and return {"files": test_paths, "passed": bool, "output": str}.
    `test_paths` can be a single Path, a list of Path, or None.
    """
    cmd = ["npm", "run", test_cmd]
    if test_paths is not None:
        if isinstance(test_paths, list):
            cmd.extend(str(p) for p in test_paths)
        else:
            cmd.append(str(test_paths))

    proc = subprocess.Popen(
        cmd,
        cwd=project_root,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True,
    )
    out, err = proc.communicate()

    logger.info("Run (%s):\n%s", " ".join(cmd), out + err)

    passed = proc.returncode == 0 and "failing" not in (out + err)
    return {"files": test_paths, "passed": passed, "output": out + err}


# -----------------------------------------------------------------------------
# Step 1: Generate unit test with time check & detailed logging
# -----------------------------------------------------------------------------
def generate_unit_test(
    project_root: Path,
    unit_dir: Path,
    fail_dir: Path,
    src: str,
    mut_name: str,
    proj_name: str,
    pkg_name: str,
    budget: int
) -> Tuple[Optional[Path], int]:
    global START_TIME
    prompt = build_unit_prompt(src, mut_name, proj_name, pkg_name)
    attempt = 0
    while budget > 0:
        elapsed = time.time() - START_TIME
        if elapsed > TIME_LIMIT_SECONDS:
            logger.error(
                "Time limit of %d seconds exceeded; aborting unit test generation for %s",
                TIME_LIMIT_SECONDS, mut_name
            )
            return None, 0
        logger.info("Elapsed %.2fs - Prompt for unit test generation:\n%s", elapsed, prompt)
        comp = llm_generate(prompt)
        elapsed = time.time() - START_TIME
        body = comp.split("```javascript\n")[-1].split("\n```")[0]
        code = body
        logger.info("Elapsed %.2fs - Output from unit test generation:\n%s", elapsed, code)

        tmp = unit_dir.parent / "tmp" / f"unit_{mut_name}_{attempt}.js"
        tmp.parent.mkdir(parents=True, exist_ok=True)
        tmp.write_text(code)
        res = run_test(project_root, tmp, "test")
        if res["passed"]:
            dest = unit_dir / f"test_{mut_name}_{attempt}.js"
            dest.parent.mkdir(exist_ok=True)
            shutil.move(str(tmp), str(dest))
            logger.info("Unit test passed for %s on attempt %d", mut_name, attempt)
            budget -= 1
            return dest, budget
        else:
            fail_dest = fail_dir / f"unit_{mut_name}_{attempt}.js"
            fail_dest.parent.mkdir(exist_ok=True)
            shutil.move(str(tmp), str(fail_dest))
        budget -= 1
        attempt += 1

    return None, budget

# -----------------------------------------------------------------------------
# Step 2: Generate branch tests with time checks & logging
# -----------------------------------------------------------------------------
def generate_branch_tests(                     # ← signature unchanged
    project_root: Path,
    branch_dir: Path,
    fail_dir: Path,
    src: str,
    loc: Dict[str, Any],
    mut_name: str,
    proj_name: str,
    pkg_name: str,
    passing_test: Path,                        #  (still unused, kept for compat)
    budget: int,
) -> int:
    """Target the current top-ranked uncovered branch; on each successful test
       run nyc *only* on tests belonging to this mutation.  Returns remaining
       budget.
    """
    global START_TIME

    while budget > 0:
        # ------------------------------------------------------------------ 1
        # Load latest coverage snapshot
        try:
            report = json.loads(Path("coverage/coverage-final.json").read_text())
        except FileNotFoundError:
            logger.warning("No coverage data – aborting branch generation.")
            return budget

        cov = report.get(loc["file"].replace('dist', 'src'))
        if not cov:
            return budget   # file missing

        # ------------------------------------------------------------------ 2
        # Collect still-uncovered branches inside this function
        raw_branches: List[Dict[str, int]] = []
        for bid, info_map in cov["branchMap"].items():
            if (
                info_map["loc"]["start"]["line"] >= loc["startLine"]
                and info_map["loc"]["end"]["line"]   <= loc["endLine"]
            ):
                counts = cov["b"][str(bid)]
                for idx, count in enumerate(counts):
                    if (
                        count == 0
                        and "locations" in info_map
                        and "line" in info_map["locations"][idx]["start"]
                        and "line" in info_map["locations"][idx]["end"]
                    ):
                        raw_branches.append(info_map["locations"][idx])

        if not raw_branches:
            logger.info("All branches now covered for %s.", mut_name)
            break

        br    = order_branches(raw_branches)[0]        # top ranked
        bdesc = f"{br['start']}-{br['end']}"

        # ------------------------------------------------------------------ 3
        # Try to cover that branch
        full_prompt = build_branch_prompt(
            src, mut_name, proj_name, pkg_name, br, loc
        )
        logger.info("▶  Target branch %s (budget %d)", bdesc, budget)

        for attempt in range(MAX_COV_TESTS):
            if budget <= 0:
                break
            if time.time() - START_TIME > TIME_LIMIT_SECONDS:
                logger.error("Time limit exceeded during %s – abort branch gen.", mut_name)
                return 0

            elapsed = time.time() - START_TIME
            logger.info(
                "Elapsed %.2fs – Prompt for branch test generation (branch %s, try %d):\n%s",
                elapsed, bdesc, attempt, full_prompt,
            )

            comp   = llm_generate(full_prompt)
            body   = comp.split("```javascript\n")[-1].split("\n```")[0]
            code   = body

            elapsed = time.time() - START_TIME
            logger.info(
                "Elapsed %.2fs – Output from branch test generation (branch %s, try %d):\n%s",
                elapsed, bdesc, attempt, code,
            )

            logger.info("Elapsed %.2fs - Output from unit test generation:\n%s", elapsed, code)

            tmp = branch_dir.parent / "tmp" / f"branch_{mut_name}_{bdesc}_{attempt}.js"
            tmp.parent.mkdir(parents=True, exist_ok=True)
            tmp.write_text(code)

            res = run_test(project_root, tmp, "test")
            budget -= 1

            if res["passed"]:
                dest = branch_dir / f"test_{mut_name}_{bdesc}_{attempt}.js"
                dest.parent.mkdir(exist_ok=True)
                shutil.move(str(tmp), str(dest))
                logger.info("✔  Covered branch %s with %s", bdesc, dest.name)

                # ---------------------------------------------------------------- 4
                # Refresh coverage with *all* tests for this mut_name
                base_dir     = branch_dir.parent          # …/gen_test/<pkg>
                unit_tests   = list((base_dir / "unit"  ).glob(f"test_{mut_name}*.js"))
                branch_tests = list((base_dir / "branch").glob(f"test_{mut_name}*.js"))
                paths        = unit_tests + branch_tests

                if not paths:
                    logger.warning("No gathered tests for %s during coverage refresh.", mut_name)
                else:
                    _ = run_test(project_root, paths, "test:coverage")
                break
            else:
                fail_dest = fail_dir / f"branch_{mut_name}_{bdesc}_{attempt}.js"
                fail_dest.parent.mkdir(exist_ok=True)
                shutil.move(str(tmp), str(fail_dest))
        else:
            logger.info("✘  Could not cover branch %s after %d attempts.", bdesc, MAX_COV_TESTS)

    return budget


# -----------------------------------------------------------------------------
# Main orchestration
# -----------------------------------------------------------------------------
def generate_tests_for_project(
    project_root: Path,
    proj_name: str,
    api_json: Path,
) -> None:
    global START_TIME
    START_TIME = time.time()
    logger.info("Test generation started at %s", time.strftime('%Y-%m-%d %H:%M:%S'))

    pkg_name = proj_name.replace("-", "_").replace(".js", "")
    base = project_root / "gen_test" / proj_name
    unit_dir, branch_dir, fail_dir = (base / "unit", base / "branch", base / "fail")
    for d in (unit_dir, branch_dir, fail_dir):
        d.mkdir(parents=True, exist_ok=True)

    api_defs = json.loads(api_json.read_text())
    funcs = [(n, i) for n, i in api_defs if i.get("type") == "function" and "location" in i]

    # ------------------------------------------------------------------ PHASE 1
    passing_tests: Dict[str, Path] = {}
    for mut_name, info in funcs:
        logger.info("[PHASE-1]  ==> %s", mut_name)
        loc = info["location"]
        src = Path(loc["file"]).read_text().splitlines(keepends=True)
        src = "".join(src[loc["startLine"] - 1 : loc["endLine"]])

        unit_budget = MAX_UNIT_BUDGET
        passing, _ = generate_unit_test(
            project_root, unit_dir, fail_dir,
            src, mut_name,
            proj_name, pkg_name,
            unit_budget,
        )
        if passing:
            passing_tests[mut_name] = passing

    if not passing_tests:
        logger.warning("No API received a passing unit test – stopping.")
        return

    # ------------------------------------------------------------------ PHASE 2
    for mut_name, info in funcs:
        if mut_name not in passing_tests:
            continue  # we have nothing to branch-cover if unit test failed

        logger.info("[PHASE-2]  ==> %s", mut_name)
        loc = info["location"]
        src = Path(loc["file"]).read_text().splitlines(keepends=True)
        src = "".join(src[loc["startLine"] - 1 : loc["endLine"]])

        _ = run_test(project_root, passing_tests[mut_name], "test:coverage")

        branch_budget = MAX_COV_BUDGET
        branch_budget = generate_branch_tests(
            project_root, branch_dir, fail_dir,
            src, loc,
            mut_name, proj_name, pkg_name,
            passing_tests[mut_name],
            branch_budget,
        )

        total_used = (MAX_COV_BUDGET - branch_budget) + 1  # +1 unit test
        logger.info("Total tests generated for %s: %d", mut_name, total_used)

# -----------------------------------------------------------------------------
# CLI entrypoint
# -----------------------------------------------------------------------------
if __name__ == "__main__":
    import argparse
    parser = argparse.ArgumentParser(description="LLM-based JS test generator")
    parser.add_argument("project", help="Project directory/name")
    parser.add_argument("api_json", type=Path, help="Path to API JSON file")
    args = parser.parse_args()
    generate_tests_for_project(Path("."), args.project, args.api_json)

