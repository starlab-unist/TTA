def intersection(interval1, interval2):
    def is_prime(num):
        if num == 1 or num == 0:
            return False
        if num == 2:
            return True
        for i in range(2, num):
            if num % i == 0:
                return False
        return True

    l = max(interval1[0], interval2[0])
    r = min(interval1[1], interval2[1])
    length = r - l
    if length > 0 and is_prime(length):
        return "YES"
    return "NO"

def check_interval_for_prime_length(range1, range2):
    def prime_check(number):
        if number in (0, 1):
            return False
        if number == 2:
            return True
        for divisor in range(2, number):
            if number % divisor == 0:
                return False
        return True

    start = max(range1[0], range2[0])
    end = min(range1[1], range2[1])
    span = end - start
    if span > 0 and prime_check(span):
        return "YES"
    return "NO"

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ((1, 5), (3, 7)),   # Overlapping interval with prime length 2
        ((10, 20), (15, 25)), # Overlapping interval with non-prime length 5
        ((5, 5), (5, 5)),     # No overlap
        ((2, 3), (3, 4)),     # No overlap
        ((0, 1), (1, 2)),     # No overlap
        ((1, 10), (5, 6)),    # Overlapping interval with prime length 1
        ((1, 11), (5, 7)),    # Overlapping interval with non-prime length 2
        ((4, 9), (8, 13)),    # Overlapping interval with prime length 1
        ((1, 20), (5, 15)),   # Overlapping interval with non-prime length 10
        ((7, 11), (9, 13))    # Overlapping interval with prime length 2
    ]

    def test_0(self):
        self.assertEqual(intersection(self.test_cases[0][0], self.test_cases[0][1]), check_interval_for_prime_length(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(intersection(self.test_cases[1][0], self.test_cases[1][1]), check_interval_for_prime_length(self.test_cases[1][0], self.test_cases[1][1]))

    def test_2(self):
        self.assertEqual(intersection(self.test_cases[2][0], self.test_cases[2][1]), check_interval_for_prime_length(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(intersection(self.test_cases[3][0], self.test_cases[3][1]), check_interval_for_prime_length(self.test_cases[3][0], self.test_cases[3][1]))

    def test_4(self):
        self.assertEqual(intersection(self.test_cases[4][0], self.test_cases[4][1]), check_interval_for_prime_length(self.test_cases[4][0], self.test_cases[4][1]))
    
    def test_5(self):
        self.assertEqual(intersection(self.test_cases[5][0], self.test_cases[5][1]), check_interval_for_prime_length(self.test_cases[5][0], self.test_cases[5][1]))

    def test_6(self):
        self.assertEqual(intersection(self.test_cases[6][0], self.test_cases[6][1]), check_interval_for_prime_length(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(intersection(self.test_cases[7][0], self.test_cases[7][1]), check_interval_for_prime_length(self.test_cases[7][0], self.test_cases[7][1]))

    def test_8(self):
        self.assertEqual(intersection(self.test_cases[8][0], self.test_cases[8][1]), check_interval_for_prime_length(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(intersection(self.test_cases[9][0], self.test_cases[9][1]), check_interval_for_prime_length(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()