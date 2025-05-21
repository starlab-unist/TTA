def search(lst):
    if not lst:  # Check if the list is empty
        return -1
    
    frq = [0] * (max(lst) + 1)
    for i in lst:
        frq[i] += 1;

    ans = -1
    for i in range(1, len(frq)):
        if frq[i] >= i:
            ans = i
    
    return ans


def find_max_frequency_index(numbers):
    if not numbers:  # Check if the list is empty
        return -1

    max_value = max(numbers)
    frequency_array = [0] * (max_value + 1)
    
    for number in numbers:
        frequency_array[number] += 1

    result = -1
    index = 1
    while index < len(frequency_array):
        if frequency_array[index] >= index:
            result = index
        index += 1

    return result


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 2, 3, 3, 3],
        [4, 5, 6, 7, 8, 9, 10],
        [1, 1, 1, 1, 1],
        [2, 2, 3, 3, 4, 4, 4, 4],
        [1, 2, 3, 4, 5],
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1],
        [1, 1, 2, 2, 2, 3, 3, 3, 3],
        [5, 5, 5, 5, 5, 5],
        [1],
        []
    ]

    def test_0(self):
        self.assertEqual(search(self.test_cases[0]), find_max_frequency_index(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(search(self.test_cases[1]), find_max_frequency_index(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(search(self.test_cases[2]), find_max_frequency_index(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(search(self.test_cases[3]), find_max_frequency_index(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(search(self.test_cases[4]), find_max_frequency_index(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(search(self.test_cases[5]), find_max_frequency_index(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(search(self.test_cases[6]), find_max_frequency_index(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(search(self.test_cases[7]), find_max_frequency_index(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(search(self.test_cases[8]), find_max_frequency_index(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(search(self.test_cases[9]), find_max_frequency_index(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()