def get_odd_collatz(n):
    if n % 2 == 0:
        odd_collatz = [] 
    else:
        odd_collatz = [n]
    while n > 1:
        if n % 2 == 0:
            n = n / 2
        else:
            n = n * 3 + 1
            
        if n % 2 == 1:
            odd_collatz.append(int(n))

    return sorted(odd_collatz)

def extract_odd_numbers_in_sequence(starting_value):
    if starting_value % 2 == 0:
        sequence_of_odds = []
    else:
        sequence_of_odds = [starting_value]

    current_value = starting_value
    while current_value > 1:
        if current_value % 2 == 0:
            current_value //= 2
        else:
            current_value = current_value * 3 + 1

        if current_value % 2 != 0:
            sequence_of_odds.append(current_value)

    return sorted(sequence_of_odds)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    ]

    def test_0(self):
        self.assertEqual(get_odd_collatz(self.test_cases[0]), extract_odd_numbers_in_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(get_odd_collatz(self.test_cases[1]), extract_odd_numbers_in_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(get_odd_collatz(self.test_cases[2]), extract_odd_numbers_in_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(get_odd_collatz(self.test_cases[3]), extract_odd_numbers_in_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(get_odd_collatz(self.test_cases[4]), extract_odd_numbers_in_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(get_odd_collatz(self.test_cases[5]), extract_odd_numbers_in_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(get_odd_collatz(self.test_cases[6]), extract_odd_numbers_in_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(get_odd_collatz(self.test_cases[7]), extract_odd_numbers_in_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(get_odd_collatz(self.test_cases[8]), extract_odd_numbers_in_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(get_odd_collatz(self.test_cases[9]), extract_odd_numbers_in_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()