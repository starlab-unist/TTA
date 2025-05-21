# Automated Test Generation and Evaluation

This repository supports running test generation experiments and evaluating the effectiveness of the generated tests in terms of coverage and error detection.

## 1. Run Experiments

To run all experiments, simply execute:

```bash
bash run.sh
```

This will generate tests for five target projects using both our system and the baseline (TESTPILOT).

---

## 2. Evaluate Test Coverage

We evaluate statement coverage across three test sources:

* **System (ours):** `/root/eval/coverage/coverage_*.log`
* **TESTPILOT:** `/root/eval/testpilot/coverage_*.log`
* **Developer-written tests:** `/root/projects/*/coverage.log`

### Metric

For each of the five projects, compute the following metric:

```
(system or testpilot coverage) / (developer coverage)
```

This ratio measures how effective the generated tests are compared to the original developer-written tests. A higher ratio indicates better test coverage.

---

## 3. Evaluate Error Detection Rate

We test our system-generated tests against 10 known buggy program versions.

### Logs

Test results are stored in:

```
/root/eval/error/test_*.log
```

### Metric

Count how many tests **fail** (i.e., they correctly detect a bug). Then compute:

```
(number of failing tests) / 10
```

This is the **error detection rate**. A higher rate indicates stronger bug-detection capability of the generated tests.

---

## 4. Expected Results


---

### Developer Test Coverage

| Project     | Statement (%) | Branch (%) |
| ----------- | ------------- | ---------- |
| bluebird    | 36.14         | 51.55      |
| q           | 34.25         | 19.51      |
| Complex.js  | 71.82         | 67.54      |
| pull-stream | 90.96         | 80.84      |
| memfs       | 82.60         | 61.04      |

---

### TestPilot Coverage

| Project     | Statement (%) | Branch (%) |
| ----------- | ------------- | ---------- |
| bluebird    | 46.39         | 30.22      |
| q           | 63.58         | 51.22      |
| pull-stream | 81.63         | 64.95      |
| Complex.js  | 56.59         | 40.32      |
| memfs       | 46.76         | 30.96      |

---

### System Coverage

| Project     | Statement (%) | Branch (%) |
| ----------- | ------------- | ---------- |
| bluebird    | 55.05         | 37.74      |
| q           | 77.55         | 67.01      |
| pull-stream | 82.50         | 66.35      |
| Complex.js  | 54.56         | 40.65      |
| memfs       | 66.35         | 42.87      |

---

### TestPilot Coverage / Dev Test

| Project     | Stmt / Dev | Branch / Dev |
| ----------- | ---------- | ------------ |
| bluebird    | 1.2836     | 0.5862       |
| q           | 1.8564     | 2.6253       |
| pull-stream | 0.8974     | 0.8034       |
| Complex.js  | 0.7879     | 0.5970       |
| memfs       | 0.5661     | 0.5072       |

---

### System Coverage / Dev Test

| Project     | Stmt / Dev | Branch / Dev |
| ----------- | ---------- | ------------ |
| bluebird    | 1.5231     | 0.7322       |
| q           | 2.2644     | 3.4341       |
| pull-stream | 0.9072     | 0.8210       |
| Complex.js  | 0.7598     | 0.6021       |
| memfs       | 0.8031     | 0.7023       |

---

### Error Detection Rate

| Project      | Error Detection |
|--------------|------------------|
| bluebird     | 2 / 2            |
| q            | 0 / 2            |
| pull-stream  | 2 / 2            |
| Complex.js   | 2 / 2            |
| memfs        | 2 / 2            |

