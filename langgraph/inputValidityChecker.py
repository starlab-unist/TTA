import re
from typing import List, Tuple
def read_test_cases_by_line(file_path: str) -> List[str]:
    """

    """
    with open(file_path, 'r', encoding='utf-8') as f:
        text = f.read()


    m = re.search(r'\btest_cases\b|\btestCases\b', text)
    if not m:
        raise RuntimeError(f"`Unable to find TestCase: {file_path}")
    idx = m.end()

   
    idx = text.find('[', text.find('=', idx))
    if idx < 0:
        raise RuntimeError(f"`Unable to find paired bracket: {file_path}")

    
    depth = 0
    end_idx = None
    for i, ch in enumerate(text[idx:], start=idx):
        if ch == '[':
            depth += 1
        elif ch == ']':
            depth -= 1
            if depth == 0:
                end_idx = i
                break
    if end_idx is None:
        raise RuntimeError(f"Unable to find paired bracket: {file_path}")

    # 4) 블록 내부 줄별 처리
    block = text[idx+1:end_idx]
    lines = block.splitlines()
    inputs_only: List[str] = []

    for line in lines:
        s = line.strip()
        if not s or s == ',':
            continue

        s = re.split(r'//|#', s)[0].strip()
        if not s:
            continue

        
        if s.endswith(','):
            s = s[:-1].rstrip()

      
        if s.startswith('{') and 'input' in s:
            content = s.lstrip('{').rstrip('}').strip()
            parts, buf, d2 = [], "", 0
            for ch in content:
                if ch == '[':
                    d2 += 1; buf += ch
                elif ch == ']':
                    d2 -= 1; buf += ch
                elif ch == ',' and d2 == 0:
                    parts.append(buf.strip()); buf = ""
                else:
                    buf += ch
            if buf:
                parts.append(buf.strip())

            
            input_part = next((p for p in parts if p.strip().startswith('input')), None)
            vals: List[str] = []
            if input_part:
                _, val = input_part.split(':', 1)
                val = val.strip()
                if val.startswith('[') and val.endswith(']'):
                    inner = val[1:-1].strip()
                    for x in inner.split(','):
                        x = x.strip().strip("'\"")
                        if x:
                            vals.append(x)
                else:
                   
                    vals.append(val.strip().strip("'\""))
            s = ", ".join(vals)

    
        else:
            inner = s
            
            if (inner.startswith('(') and inner.endswith(')')) or \
               (inner.startswith('[[') and inner.endswith(']')):
                inner = inner[1:-1].strip()

            
            if inner.startswith('['):
                d3 = 0
                first_end = None
                for j, ch2 in enumerate(inner):
                    if ch2 == '[':
                        d3 += 1
                    elif ch2 == ']':
                        d3 -= 1
                        if d3 == 0:
                            first_end = j
                            break
                if first_end is not None:
                    arr = inner[1:first_end].strip()
                    tokens = [tok.strip().strip("'\"") for tok in arr.split(',') if tok.strip()]
                    s = ", ".join(tokens)
                else:
                    s = ""

         
            elif s.startswith('[') and s.endswith(']'):
                inner2 = s[1:-1].strip()
                tokens = [tok.strip().strip("'\"") for tok in inner2.split(',') if tok.strip()]
                s = ", ".join(tokens)

           
            else:
                s = re.sub(r'[\[\]\(\)\{\}\'"]', '', s).strip()

 
        s = s.lower()
        s = re.sub(r'\s*,\s*', ', ', s).strip()

      
        s = re.sub(r'\bnone\b|\bnull\b', 'null', s)

        inputs_only.append(s)

    return inputs_only

def compare_test_cases(
    python_dir: str,
    js_dir: str,
    total_files: int = 164
) -> Tuple[int, List[int], List[str], List[str]]:
    
    mismatches = 0
    invalid_indices: List[int] = []
    invalid_pypaths: List[str] = []
    invalid_jspaths: List[str] = []

    for i in range(total_files):
        py_path = f"{python_dir}/{i}.py"
        js_path = f"{js_dir}/{i}.test.js"
        try:
            py_in = read_test_cases_by_line(py_path)
            js_in = read_test_cases_by_line(js_path)
            if py_in != js_in:
                mismatches += 1
                invalid_indices.append(i)
                invalid_pypaths.append(py_path)
                invalid_jspaths.append(js_path)
        except RuntimeError:
            mismatches += 1
            invalid_indices.append(i)
            invalid_pypaths.append(py_path)
            invalid_jspaths.append(js_path)

    return mismatches, invalid_indices, invalid_pypaths, invalid_jspaths


