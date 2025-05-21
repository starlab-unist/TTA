def fruit_distribution(s, n):
    lis = list()
    for i in s.split(' '):
        if i.isdigit():
            lis.append(int(i))
    return n - sum(lis)


def calculate_remaining_fruits(fruit_string, total_fruits):
    numbers = []
    for item in fruit_string.split():
        if item.isdigit():
            numbers.append(int(item))
    remaining_fruits = total_fruits - sum(numbers)
    return remaining_fruits

# method name: fruit_distribution -> calculate_remaining_fruits
# parameter name: s -> fruit_string, n -> total_fruits
# variable name: lis -> numbers
# replaced 'split(' ')' with 'split()' which is equivalent for splitting by spaces
# introduced a new variable 'remaining_fruits' to store the result before returning

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("1 2 3", 10),
        ("5 5 5", 20),
        ("", 10),
        ("10 20 30", 100),
        ("100", 150),
        ("1 2 3 4 5", 20),
        ("7 8 9", 30),
        ("0 0 0", 5),
        ("123", 200),
        ("456 789", 1500)
    ]

    def test_0(self):
        self.assertEqual(fruit_distribution(*self.test_cases[0]), calculate_remaining_fruits(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fruit_distribution(*self.test_cases[1]), calculate_remaining_fruits(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fruit_distribution(*self.test_cases[2]), calculate_remaining_fruits(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fruit_distribution(*self.test_cases[3]), calculate_remaining_fruits(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fruit_distribution(*self.test_cases[4]), calculate_remaining_fruits(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fruit_distribution(*self.test_cases[5]), calculate_remaining_fruits(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fruit_distribution(*self.test_cases[6]), calculate_remaining_fruits(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fruit_distribution(*self.test_cases[7]), calculate_remaining_fruits(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fruit_distribution(*self.test_cases[8]), calculate_remaining_fruits(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fruit_distribution(*self.test_cases[9]), calculate_remaining_fruits(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()