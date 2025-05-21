def is_happy(s):
    if len(s) < 3:
      return False

    for i in range(len(s) - 2):
      
      if s[i] == s[i+1] or s[i+1] == s[i+2] or s[i] == s[i+2]:
        return False
    return True


def check_happiness(sequence):
    if len(sequence) < 3:
        return False

    index = 0
    while index < len(sequence) - 2:
        if sequence[index] == sequence[index + 1] or \
           sequence[index + 1] == sequence[index + 2] or \
           sequence[index] == sequence[index + 2]:
            return False
        index += 1

    return True


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "abc",       # happy
        "aabbcc",    # not happy
        "abac",      # happy
        "aaa",       # not happy
        "abcdefg",   # happy
        "a",         # not happy (less than 3 characters)
        "ab",        # not happy (less than 3 characters)
        "aab",       # not happy
        "abcabc",    # happy
        "aabbba"     # not happy
    ]

    def test_0(self):
        self.assertEqual(is_happy(self.test_cases[0]), check_happiness(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_happy(self.test_cases[1]), check_happiness(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_happy(self.test_cases[2]), check_happiness(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_happy(self.test_cases[3]), check_happiness(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_happy(self.test_cases[4]), check_happiness(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_happy(self.test_cases[5]), check_happiness(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_happy(self.test_cases[6]), check_happiness(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_happy(self.test_cases[7]), check_happiness(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_happy(self.test_cases[8]), check_happiness(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_happy(self.test_cases[9]), check_happiness(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()