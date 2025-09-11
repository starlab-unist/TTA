from langchain_ollama import ChatOllama
from langchain.prompts import ChatPromptTemplate
from inputValidityChecker import compare_test_cases
from pydantic import BaseModel
from typing import Literal
from langchain.output_parsers import PydanticOutputParser
from langchain_core.exceptions import OutputParserException
import json
import re

class AnswerSchema(BaseModel):
    answer: Literal["Equal", "Not_Equal"]


SYSTEM_PROMPT = r"""
You are a Software Engineering expert.
Your ONLY task is to decide whether TWO test suites use the SAME INPUTS.
Return **ONLY** one of:
{"answer":"Equal"}
or
{"answer":"Not_Equal"}

Rules:
- Compare INPUTS ONLY (arguments passed to the function under test for each concrete test invocation).
- Ignore expected values, assertion messages, helper names, and comments.
- Consider parameterized/data-driven styles (unittest lists, Jest arrays/objects, JUnit arrays/data providers).
- Normalize before comparing:
  - Case-insensitive tokens (except numbers/symbols).
  - Trim spaces; normalize comma spacing to ", ".
  - None/null/undefined -> "null".
  - Booleans to "true"/"false" (lowercase strings).
  - Arrays/tuples -> JSON-like strings, e.g., "[1, 2, 3]".
- Treat the sets of inputs as a **multiset**: order does not matter, counts do.

- Runtime differences matter:
  - Python supports string repetition: "AEIOU" * 5 -> "AEIOUAEIOUAEIOUAEIOUAEIOU".
  - JS/Java do not; only consider them equivalent if the expanded literal appears.

- If and only if ALL concrete input sets match as a multiset, answer {"answer":"Equal"}.
  Otherwise answer {"answer":"Not_Equal"}.
- Do NOT output anything else.

=====================================================
Example A (Equal) — Your JUnit style vs Python unittest

Java (JUnit 5; core structure):
public class HumanEval_0 {
  static class Source {
    public static boolean hasCloseElements(List<Double> numbers, double threshold) { /* ... */ }
  }
  static class Transformed {
    public boolean containsNearbyElements(List<Double> values, double limit) { /* ... */ }
  }
  private static final Object[][] testCases = {
    {List.of(1.0, 2.0, 3.0), 0.5,  false},
    {List.of(1.0, 2.0, 3.0), 1.5,  true},
    {List.of(1.1, 2.2, 3.3), 0.1,  false},
    {List.of(1.1, 2.2, 3.3), 1.2,  true},
    {List.of(0.0, 0.0, 0.0), 0.0,  true},
    {List.of(0.0, 0.1, 0.2), 0.05, false},
    {List.of(5.0, 4.9, 4.8), 0.2,  true},
    {List.of(10.0, 20.0, 30.0), 5.0, false},
    {List.of(1.0, 1.0, 1.0, 1.0), 0.1, true},
    {List.of(1.0, 2.0, 3.0, 4.0, 5.0), 1.1, true}
  };
  @Test
  public void test_0() { /* assertEquals(Source.hasCloseElements(testCases[0][0], testCases[0][1]),
                                       new Transformed().containsNearbyElements(testCases[0][0], testCases[0][1])); */ }
  /* ... similar tests for indices 1..9 ... */
}

Python (unittest; core structure):
from typing import List
import unittest
def has_close_elements(numbers: List[float], threshold: float) -> bool: ...
def contains_nearby_elements(values: List[float], limit: float) -> bool: ...
class T(unittest.TestCase):
  test_cases = [
    ([1.0, 2.0, 3.0], 0.5),
    ([1.0, 2.0, 3.0], 1.5),
    ([1.1, 2.2, 3.3], 0.1),
    ([1.1, 2.2, 3.3], 1.2),
    ([0.0, 0.0, 0.0], 0.0),
    ([0.0, 0.1, 0.2], 0.05),
    ([5.0, 4.9, 4.8], 0.2),
    ([10.0, 20.0, 30.0], 5.0),
    ([1.0, 1.0, 1.0, 1.0], 0.1),
    ([1.0, 2.0, 3.0, 4.0, 5.0], 1.1),
  ]
  def test_0(self): self.assertEqual(has_close_elements(*self.test_cases[0]), contains_nearby_elements(*self.test_cases[0]))
  /* ... similar tests for indices 1..9 ... */

Expected JSON response:
{"answer":"Equal"}

=====================================================
Example B (Equal) — Your Jest style vs Python unittest

JavaScript (Jest; core structure):
function hasCloseElements(numbers, threshold) { /* ... */ }
function containsNearbyElements(values, limit) { /* ... */ }
describe('equivalence', () => {
  const testCases = [
    { input: [1.0, 2.0, 3.0], threshold: 0.5,  expected: false },
    { input: [1.0, 2.0, 3.0], threshold: 1.5,  expected: true },
    { input: [1.1, 2.2, 3.3], threshold: 0.1,  expected: false },
    { input: [1.1, 2.2, 3.3], threshold: 1.2,  expected: true },
    { input: [0.0, 0.0, 0.0], threshold: 0.0,  expected: true },
    { input: [0.0, 0.1, 0.2], threshold: 0.05, expected: false },
    { input: [5.0, 4.9, 4.8], threshold: 0.2,  expected: true },
    { input: [10.0, 20.0, 30.0], threshold: 5.0, expected: false },
    { input: [1.0, 1.0, 1.0, 1.0], threshold: 0.1, expected: true },
    { input: [1.0, 2.0, 3.0, 4.0, 5.0], threshold: 1.1, expected: true }
  ];
  testCases.forEach(({ input, threshold }, i) => {
    it(`test_${i}`, () => {
      expect(typeof threshold).toBe('number'); // focus is on inputs (input, threshold)
    });
  });
});

Python (unittest; same as in Example A).

Expected JSON response:
{"answer":"Equal"}

=====================================================
Example C (Not_Equal) — One side has an extra/mismatched input

Python (unittest; core):
class T(unittest.TestCase):
  test_cases = [([1.0, 2.0, 3.0], 0.5), ([1.0, 2.0, 3.0], 1.5)]

JavaScript (Jest; core):
const testCases = [
  { input: [1.0, 2.0, 3.0], threshold: 0.5 },
  { input: [1.0, 2.0, 3.0], threshold: 1.5 },
  { input: [99.9], threshold: 0.1 } // extra
];

Expected JSON response:
{"answer":"Not_Equal"}

=====================================================
Runtime difference example (string repetition):
Python input: ("AEIOU" * 5, 8)  -> ("AEIOUAEIOUAEIOUAEIOUAEIOU", 8)
JS/Java must provide the fully expanded literal to be considered the same.
"""



def _extract_json(text: str) -> str:
    m = re.search(r'\{[^{}]*\}', text, flags=re.DOTALL)
    return m.group(0) if m else text.strip()

def validateInput(pythonDir, jsDir):
   
    pythonDir = pythonDir
    jsDir = jsDir
    
    prompt = ChatPromptTemplate.from_messages(
        [
            ("system", SYSTEM_PROMPT),
            ("human", "{{input}}"),
        ],
        template_format="jinja2",
    )
    model_id = "qwen2.5-coder:32b-instruct-q8_0"
    llm = ChatOllama(model=MODEL_ID, temperature=0.0)
    prompt | llm

    mismatches, indices, pypaths, jspaths = compare_test_cases(pythonDir, jsDir)
    parser = PydanticOutputParser(pydantic_object=AnswerSchema)
    logger = []
    ret_js_path = []
    ret_py_path = []
    ret_idx = []
    print(f"Total mismatches: {mismatches}")
    if indices:
        print("\nInvalid file indices and paths:")
        for idx, py, js in zip(indices, pypaths, jspaths):
            print(f"[{idx}]: PY {py}, JS {js}")
            pythonContent = ''.join(open(py).readlines())
            jSContent     = ''.join(open(js).readlines())


            chain = prompt | llm


            question = f'''
            Are the provided test cases in both code snippets Equal or Not_Equal?

            Python Test Code:
            {pythonContent}

            JavaScript Test Code:
            {jSContent}

            Whenever asked whether two test suites use the same inputs, respond **only** with a JSON object:
            {{"answer":"Equal"}}
            or
            {{"answer":"Not_Equal"}}

             When you are evaluating the test case please consider the difference between two run time environments.

            e.g.) 

            ("AEIOU" * 5, 8) for js and python is different.

            for python it is "AEIOUAEIOUAEIOUAEIOUAEIOU" but for js it is NaN
            '''

            raw_message = chain.invoke({"input": question})
            raw_text = raw_message.content
            try:
                result = parser.parse(raw_text)
            except OutputParserException as e:
                print(f"Output parsing error: {e}")
                print(f"Raw message: {raw_message}")
                break
            except Exception as e:
                print(f"Unexpected error: {e}")
                break
            print(result.answer)
            if result.answer == "Not_Equal":
                ret_idx.append(idx)
                ret_js_path.append(js)
                ret_py_path.append(py)
           
            logger.append({'index': idx, 'answer': result.answer})


    return ret_idx, ret_js_path, ret_py_path

