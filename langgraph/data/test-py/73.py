# Source Code (Original Function)
def smallest_change(arr):
    ans = 0
    for i in range(len(arr) // 2):
        if arr[i] != arr[len(arr) - i - 1]:
            ans += 1
    return ans

# Transformed Code (Semantically Equivalent)
def minimal_adjustments(sequence):
    adjustments_needed = 0
    index = 0
    while index < len(sequence) // 2:
        if sequence[index] != sequence[-index - 1]:
            adjustments_needed += 1
        index += 1
    return adjustments_needed

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 2, 1],       # Palindrome with odd length
        [1, 2, 3, 4, 5],       # Not a palindrome
        ['a', 'b', 'c', 'b', 'a'], # Palindrome with odd length and strings
        [1, 1, 1, 1, 1],       # All elements are the same
        [1, 2, 2, 1],          # Palindrome with even length
        [1, 2, 3],             # Not a palindrome
        [],                    # Empty list
        [1],                   # Single element
        [1, 2],                # Not a palindrome
        [1, 2, 3, 4]           # Not a palindrome
    ]

    def test_0(self):
        self.assertEqual(smallest_change(self.test_cases[0]), minimal_adjustments(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(smallest_change(self.test_cases[1]), minimal_adjustments(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(smallest_change(self.test_cases[2]), minimal_adjustments(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(smallest_change(self.test_cases[3]), minimal_adjustments(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(smallest_change(self.test_cases[4]), minimal_adjustments(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(smallest_change(self.test_cases[5]), minimal_adjustments(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(smallest_change(self.test_cases[6]), minimal_adjustments(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(smallest_change(self.test_cases[7]), minimal_adjustments(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(smallest_change(self.test_cases[8]), minimal_adjustments(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(smallest_change(self.test_cases[9]), minimal_adjustments(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()