def solve(s):
    flg = 0
    idx = 0
    new_str = list(s)
    for i in s:
        if i.isalpha():
            new_str[idx] = i.swapcase()
            flg = 1
        idx += 1
    s = ""
    for i in new_str:
        s += i
    if flg == 0:
        return s[len(s)::-1]
    return s

def transform_string(input_string):
    modified = False
    position = 0
    result_chars = list(input_string)
    for char in input_string:
        if char.isalpha():
            result_chars[position] = char.swapcase()
            modified = True
        position += 1
    transformed_string = ''.join(result_chars)
    if not modified:
        return transformed_string[::-1]
    return transformed_string

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello World",
        "Python3.8",
        "1234567890",
        "!@#$%^&*()",
        "aBcDeFgHiJ",
        "ABCdef123",
        "No Change 123",
        "SWAPcase",
        "",
        " ",
    ]

    def test_0(self):
        self.assertEqual(solve(self.test_cases[0]), transform_string(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(solve(self.test_cases[1]), transform_string(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(solve(self.test_cases[2]), transform_string(self.test_cases[2]))

    def test_3(self):
        self.assertEqual(solve(self.test_cases[3]), transform_string(self.test_cases[3]))

    def test_4(self):
        self.assertEqual(solve(self.test_cases[4]), transform_string(self.test_cases[4]))

    def test_5(self):
        self.assertEqual(solve(self.test_cases[5]), transform_string(self.test_cases[5]))

    def test_6(self):
        self.assertEqual(solve(self.test_cases[6]), transform_string(self.test_cases[6]))

    def test_7(self):
        self.assertEqual(solve(self.test_cases[7]), transform_string(self.test_cases[7]))

    def test_8(self):
        self.assertEqual(solve(self.test_cases[8]), transform_string(self.test_cases[8]))

    def test_9(self):
        self.assertEqual(solve(self.test_cases[9]), transform_string(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()