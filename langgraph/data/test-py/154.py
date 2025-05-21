def cycpattern_check(a, b):
    l = len(b)
    pat = b + b
    for i in range(len(a) - l + 1):
        for j in range(l + 1):
            if a[i:i+l] == pat[j:j+l]:
                return True
    return False

def verify_cyclic_pattern(sequence, pattern):
    pattern_length = len(pattern)
    doubled_pattern = pattern + pattern
    index = 0
    
    while index <= len(sequence) - pattern_length:
        sub_index = 0
        while sub_index <= pattern_length:
            if sequence[index:index+pattern_length] == doubled_pattern[sub_index:sub_index+pattern_length]:
                return True
            sub_index += 1
        index += 1
    
    return False

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("abc", "cab"),  # Should be True (cyclical)
        ("hello", "ell"),  # Should be True (substring match)
        ("abcd", "dabc"),  # Should be True (cyclical)
        ("abcd", "abdc"),  # Should be False (not cyclical)
        ("aaaa", "aa"),    # Should be True (repeated pattern)
        ("abcdefg", "efga"),  # Should be True (cyclical)
        ("abcdefg", "gfedcba"),  # Should be False (reverse not same as cyclic shift)
        ("", ""),  # Should be True (both empty strings)
        ("a", "b"),  # Should be False (no match)
        ("pattern", ""),  # Should be True (empty pattern matches everything in sequence)
    ]

    def test_0(self):
        self.assertEqual(cycpattern_check(*self.test_cases[0]), verify_cyclic_pattern(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(cycpattern_check(*self.test_cases[1]), verify_cyclic_pattern(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(cycpattern_check(*self.test_cases[2]), verify_cyclic_pattern(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(cycpattern_check(*self.test_cases[3]), verify_cyclic_pattern(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(cycpattern_check(*self.test_cases[4]), verify_cyclic_pattern(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(cycpattern_check(*self.test_cases[5]), verify_cyclic_pattern(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(cycpattern_check(*self.test_cases[6]), verify_cyclic_pattern(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(cycpattern_check(*self.test_cases[7]), verify_cyclic_pattern(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(cycpattern_check(*self.test_cases[8]), verify_cyclic_pattern(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(cycpattern_check(*self.test_cases[9]), verify_cyclic_pattern(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()