def rounded_avg(n, m):
    if m < n:
        return -1
    summation = 0
    for i in range(n, m+1):
        summation += i
    return bin(round(summation/(m - n + 1)))

# Transformed Code (Semantically Equivalent)
def calculate_binary_average(start, end):
    if end < start:
        return -1
    total_sum = 0
    current = start
    while current <= end:
        total_sum += current
        current += 1
    average = round(total_sum / (end - start + 1))
    return bin(average)

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, 5),       # Simple range
        (0, 0),       # Single element range
        (-2, 2),      # Range with negative numbers
        (10, 10),     # Single element range at higher number
        (5, 1),       # Invalid range where end < start
        (-5, -1),     # Negative range
        (1, 100),     # Larger range
        (10, 20),     # Another simple range
        (20, 30),     # Another simple range
        (100, 200)    # Larger range
    ]

    def test_0(self):
        self.assertEqual(rounded_avg(*self.test_cases[0]), calculate_binary_average(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(rounded_avg(*self.test_cases[1]), calculate_binary_average(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(rounded_avg(*self.test_cases[2]), calculate_binary_average(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(rounded_avg(*self.test_cases[3]), calculate_binary_average(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(rounded_avg(*self.test_cases[4]), calculate_binary_average(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(rounded_avg(*self.test_cases[5]), calculate_binary_average(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(rounded_avg(*self.test_cases[6]), calculate_binary_average(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(rounded_avg(*self.test_cases[7]), calculate_binary_average(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(rounded_avg(*self.test_cases[8]), calculate_binary_average(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(rounded_avg(*self.test_cases[9]), calculate_binary_average(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()