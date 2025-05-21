def add(lst):
    return sum([lst[i] for i in range(1, len(lst), 2) if lst[i]%2 == 0])

def calculate_even_sum_at_odd_indices(numbers):
    total = 0
    index = 1
    while index < len(numbers):
        if numbers[index] % 2 == 0:
            total += numbers[index]
        index += 2
    return total

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5, 6],       # Expected output: 6 (2 + 4)
        [10, 15, 20, 25, 30, 35], # Expected output: 0 (no even numbers at odd indices)
        [2, 4, 6, 8, 10, 12],     # Expected output: 20 (4 + 8 + 12)
        [1, 3, 5, 7, 9],          # Expected output: 0 (no even numbers at odd indices)
        [],                       # Expected output: 0 (empty list)
        [0, 0, 0, 0, 0, 0],       # Expected output: 0 (all zeros)
        [1, 2],                   # Expected output: 2
        [1, 2, 3],                # Expected output: 2
        [1, 2, 3, 4],             # Expected output: 6 (2 + 4)
        [1, 2, 3, 4, 5]           # Expected output: 6 (2 + 4)
    ]

    def test_0(self):
        self.assertEqual(add(self.test_cases[0]), calculate_even_sum_at_odd_indices(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(add(self.test_cases[1]), calculate_even_sum_at_odd_indices(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(add(self.test_cases[2]), calculate_even_sum_at_odd_indices(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(add(self.test_cases[3]), calculate_even_sum_at_odd_indices(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(add(self.test_cases[4]), calculate_even_sum_at_odd_indices(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(add(self.test_cases[5]), calculate_even_sum_at_odd_indices(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(add(self.test_cases[6]), calculate_even_sum_at_odd_indices(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(add(self.test_cases[7]), calculate_even_sum_at_odd_indices(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(add(self.test_cases[8]), calculate_even_sum_at_odd_indices(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(add(self.test_cases[9]), calculate_even_sum_at_odd_indices(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()