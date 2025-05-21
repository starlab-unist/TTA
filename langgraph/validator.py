from langchain_ollama import ChatOllama
from langchain.prompts import ChatPromptTemplate
from langchain_core.runnables.base import RunnableSequence
from langchain.chains import LLMChain
from inputValidityChecker import *
from pydantic import BaseModel
from typing import Literal
from langchain.output_parsers import PydanticOutputParser

from langchain_core.exceptions import OutputParserException
import csv

class AnswerSchema(BaseModel):
    answer: Literal["Equal", "Not_Equal"]


SYSTEM_PROMPT = """
You are a Software Engineering expert.
Whenever asked whether two test suites use the same inputs, respond **only** with a JSON object:

{"answer":"Equal"}  
or  
{"answer":"Not_Equal"}

Do **not** output any greetings, explanations, or markdown—only that JSON.

When you are evaluating the test case please consider the difference between two run time environments.

e.g.) 

("AEIOU" * 5, 8) for js and python is different.

for python it is "AEIOUAEIOUAEIOUAEIOUAEIOU" but for js it is NaN

{% raw %}
=====================================================
Example 1 (matching inputs):
Python Test Code:
```python:
from typing import List
import unittest

# Source Code
def has_close_elements(numbers: List[float], threshold: float) -> bool:
    for idx, elem in enumerate(numbers):
        for idx2, elem2 in enumerate(numbers):
            if idx != idx2:
                distance = abs(elem - elem2)
                if distance < threshold:
                    return True

    return False

# Transformed Code (Semantically Equivalent)
def contains_nearby_elements(values: List[float], limit: float) -> bool:
    index = 0
    while index < len(values):
        inner_index = 0
        while inner_index < len(values):
            if index != inner_index:
                gap = abs(values[index] - values[inner_index])
                if gap < limit:
                    return True
            inner_index += 1
        index += 1

    return False

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

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
        ([1.0, 2.0, 3.0, 4.0, 5.0], 1.1)
    ]

    expected_results = [
        False,
        True,
        False,
        True,
        True,
        False,
        True,
        False,
        True,
        True
    ]

    def test_0(self):
        self.assertEqual(has_close_elements(self.test_cases[0][0], self.test_cases[0][1]), contains_nearby_elements(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(has_close_elements(self.test_cases[1][0], self.test_cases[1][1]), contains_nearby_elements(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(has_close_elements(self.test_cases[2][0], self.test_cases[2][1]), contains_nearby_elements(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(has_close_elements(self.test_cases[3][0], self.test_cases[3][1]), contains_nearby_elements(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(has_close_elements(self.test_cases[4][0], self.test_cases[4][1]), contains_nearby_elements(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(has_close_elements(self.test_cases[5][0], self.test_cases[5][1]), contains_nearby_elements(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(has_close_elements(self.test_cases[6][0], self.test_cases[6][1]), contains_nearby_elements(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(has_close_elements(self.test_cases[7][0], self.test_cases[7][1]), contains_nearby_elements(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(has_close_elements(self.test_cases[8][0], self.test_cases[8][1]), contains_nearby_elements(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(has_close_elements(self.test_cases[9][0], self.test_cases[9][1]), contains_nearby_elements(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()
```

JavaScript Test Code:
```javascript:
// Source Code
function hasCloseElements(numbers, threshold) {
    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (i !== j) {
                let distance = Math.abs(numbers[i] - numbers[j]);
                if (distance < threshold) {
                    return true;
                }
            }
        }
    }

    return false;
}

// Transformed Code (Semantically Equivalent)
function containsNearbyElements(values, limit) {
    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                let gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return false;
}

// Test Cases
describe('hasCloseElements vs containsNearbyElements equivalence tests', () => {
    const testCases = [
        { numbers: [1.0, 2.0, 3.0], threshold: 0.5, expected: false },
        { numbers: [1.0, 2.0, 3.0], threshold: 1.5, expected: true },
        { numbers: [1.1, 2.2, 3.3], threshold: 0.1, expected: false },
        { numbers: [1.1, 2.2, 3.3], threshold: 1.2, expected: true },
        { numbers: [0.0, 0.0, 0.0], threshold: 0.0, expected: true },
        { numbers: [0.0, 0.1, 0.2], threshold: 0.05, expected: false },
        { numbers: [5.0, 4.9, 4.8], threshold: 0.2, expected: true },
        { numbers: [10.0, 20.0, 30.0], threshold: 5.0, expected: false },
        { numbers: [1.0, 1.0, 1.0, 1.0], threshold: 0.1, expected: true },
        { numbers: [1.0, 2.0, 3.0, 4.0, 5.0], threshold: 1.1, expected: true }
    ];

    testCases.forEach(({ numbers, threshold, expected }, index) => {
        it(`Test case ${index}`, () => {
            expect(hasCloseElements(numbers, threshold)).toBe(expected);
            expect(containsNearbyElements(numbers, threshold)).toBe(expected);
        });
    });
});
```

for example 1 since all the test cases are same in both code snippets, you can say that they are equivalent.

you give the conclusion in the following format:
Expected JSON response:
{
"answer": "Equal"
}

========================================================
Example 2:
Python Test Code:
```python:
from typing import List
import unittest

# Source Code
def separate_paren_groups(paren_string: str) -> List[str]:
    result = []
    current_string = []
    current_depth = 0

    for c in paren_string:
        if c == '(':
            current_depth += 1
            current_string.append(c)
        elif c == ')':
            current_depth -= 1
            current_string.append(c)

            if current_depth == 0:
                result.append(''.join(current_string))
                current_string.clear()

    return result

# Transformed Code (Semantically Equivalent)
def extract_balanced_parentheses(input_sequence: str) -> List[str]:
    output_groups = []
    temp_group = []
    nesting_level = 0

    index = 0
    while index < len(input_sequence):
        character = input_sequence[index]
        if character == '(':
            nesting_level += 1
            temp_group.append(character)
        elif character == ')':
            nesting_level -= 1
            temp_group.append(character)

            if nesting_level == 0:
                output_groups.append(''.join(temp_group))
                temp_group = []

        index += 1

    return output_groups

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    ]

    def test_0(self):
        self.assertEqual(separate_paren_groups(self.test_cases[0]), extract_balanced_parentheses(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(separate_paren_groups(self.test_cases[1]), extract_balanced_parentheses(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(separate_paren_groups(self.test_cases[2]), extract_balanced_parentheses(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(separate_paren_groups(self.test_cases[3]), extract_balanced_parentheses(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(separate_paren_groups(self.test_cases[4]), extract_balanced_parentheses(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(separate_paren_groups(self.test_cases[5]), extract_balanced_parentheses(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(separate_paren_groups(self.test_cases[6]), extract_balanced_parentheses(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(separate_paren_groups(self.test_cases[7]), extract_balanced_parentheses(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(separate_paren_groups(self.test_cases[8]), extract_balanced_parentheses(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(separate_paren_groups(self.test_cases[9]), extract_balanced_parentheses(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()
    ```

JavaScript Test Code:
```javascript:
// Source Code
function separateParenGroups(parenString) {
    const result = [];
    let currentString = '';
    let currentDepth = 0;

    for (let i = 0; i < parenString.length; i++) {
        const c = parenString[i];
        if (c === '(') {
            currentDepth += 1;
            currentString += c;
        } else if (c === ')') {
            currentDepth -= 1;
            currentString += c;

            if (currentDepth === 0) {
                result.push(currentString);
                currentString = '';
            }
        }
    }

    return result;
}

// Transformed Code (Semantically Equivalent)
function extractBalancedParentheses(parenString) {
    let outputGroups = [];
    let tempGroup = [];
    let nestingLevel = 0;
    let index = 0;

    while (index < parenString.length) {
        let character = parenString[index];
        if (character === '(') {
            nestingLevel++;
            tempGroup.push(character);
        } else if (character === ')') {
            nestingLevel--;
            tempGroup.push(character);

            if (nestingLevel === 0) {
                outputGroups.push(tempGroup.join(''));
                tempGroup = [];
            }
        }

        index++;
    }

    return outputGroups;
}

// Test Cases
describe('separateParenGroups vs extractBalancedParentheses equivalence tests', () => {
    const testCases = [
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(separateParenGroups(inputText)).toEqual(extractBalancedParentheses(inputText))
    });
});
```
for example 2 since all the test cases are same in both code snippets, you can say that they are equivalent.

you give the conclusion in the following format:
Expected JSON response:
{
"answer": "Equal"
}

=============================================
Example 3:
Python Test Code:
```python:
# Source Code
def simplify(x, n):
    a, b = x.split("/")
    c, d = n.split("/")
    numerator = int(a) * int(c)
    denom = int(b) * int(d)
    if (numerator/denom == int(numerator/denom)):
        return True
    return False

# Transformed Code (Semantically Equivalent)
def check_fraction_simplification(fraction1, fraction2):
    num1, denom1 = map(int, fraction1.split('/'))
    num2, denom2 = map(int, fraction2.split('/'))
    result_numerator = num1 * num2
    result_denominator = denom1 * denom2
    return result_numerator % result_denominator == 0

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("1/2", "2/4"),    # True: (1*2) / (2*4) = 1/4
        ("3/4", "4/8"),    # True: (3*4) / (4*8) = 12/32 = 3/8
        ("5/6", "2/3"),    # False: (5*2) / (6*3) = 10/18 != int(10/18)
        ("7/9", "9/18"),   # True: (7*9) / (9*18) = 63/162 = 7/18
        ("1/1", "1/1"),    # True: (1*1) / (1*1) = 1
        ("0/1", "5/10"),   # True: (0*5) / (1*10) = 0
        ("2/3", "3/6"),    # False: (2*3) / (3*6) = 6/18 != int(6/18)
        ("10/20", "20/40"),# True: (10*20) / (20*40) = 200/800 = 1/4
        ("1/3", "3/9"),    # True: (1*3) / (3*9) = 3/27 = 1/9
        ("5/7", "7/14")    # False: (5*7) / (7*14) = 35/98 != int(35/98)
    ]

    def test_0(self):
        self.assertEqual(simplify(self.test_cases[0][0], self.test_cases[0][1]), check_fraction_simplification(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(simplify(self.test_cases[1][0], self.test_cases[1][1]), check_fraction_simplification(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(simplify(self.test_cases[2][0], self.test_cases[2][1]), check_fraction_simplification(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(simplify(self.test_cases[3][0], self.test_cases[3][1]), check_fraction_simplification(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(simplify(self.test_cases[4][0], self.test_cases[4][1]), check_fraction_simplification(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(simplify(self.test_cases[5][0], self.test_cases[5][1]), check_fraction_simplification(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(simplify(self.test_cases[6][0], self.test_cases[6][1]), check_fraction_simplification(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(simplify(self.test_cases[7][0], self.test_cases[7][1]), check_fraction_simplification(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(simplify(self.test_cases[8][0], self.test_cases[8][1]), check_fraction_simplification(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(simplify(self.test_cases[9][0], self.test_cases[9][1]), check_fraction_simplification(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()
```

JavaScript Test Code:
```javascript:
// Source Code
function simplify(x, n) {
    let [a, b] = x.split("/");
    let [c, d] = n.split("/");
    let numerator = parseInt(a) * parseInt(c);
    let denom = parseInt(b) * parseInt(d);
    if (numerator / denom === Math.floor(numerator / denom)) {
        return true;
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkFractionSimplification(x, n) {
    const [a, b] = x.split('/').map(Number);
    const [c, d] = n.split('/').map(Number);
    const numerator = a * c;
    const denom = b * d;
    return numerator % denom === 0;
}

// Test Cases
describe('simplify vs checkFractionSimplification equivalence tests', () => {
    const testCases = [
        ["1/2", "2/4"],    // True: (1*2) / (2*4) = 1/4
        ["3/4", "4/8"],    // True: (3*4) / (4*8) = 63/162 = 7/18
        ["1/1", "1/1"],    // True: (1*1) / (1*1) = 1
        ["0/1", "5/10"],   // True: (0*5) / (1*10) = 0
        ["2/3", "3/6"],    // False: (2*3) / (3*6) = 6/18 != int(6/18)
        ["10/20", "20/40"],# True: (10*20) / (20*40) = 200/800 = 1/4
        ["1/3", "3/9"],    // True: (1*3) / (3*9) = 3/27 = 1/9
        ["5/7", "7/14"]    // False: (5*7) / (7*14) = 35/98 != int(35/98)
    ];

    testCases.forEach(([x, n], index) => {
        it(`Test case ${index}`, () => {
            expect(simplify(x, n)).toBe(checkFractionSimplification(x, n));
        });
    });
});
```
for example 2 since all the test cases are not same in both code snippets.

you give the conclusion in the following format:
Expected JSON response:
{
"answer": "Not_Equal"
}
{% endraw %}
"""
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
    model_id = "qwen2.5-coder:32b-instruct-q16_0"
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

