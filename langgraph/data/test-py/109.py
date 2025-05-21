def move_one_ball(arr):
    if len(arr)==0:
      return True
    sorted_array=sorted(arr)
    my_arr=[]
    
    min_value=min(arr)
    min_index=arr.index(min_value)
    my_arr=arr[min_index:]+arr[0:min_index]
    for i in range(len(arr)):
      if my_arr[i]!=sorted_array[i]:
        return False
    return True

def check_sorted_after_rotation(sequence):
    if not sequence:
        return True

    ordered_sequence = sorted(sequence)
    smallest_element = min(sequence)
    pivot_index = sequence.index(smallest_element)

    rotated_sequence = sequence[pivot_index:] + sequence[:pivot_index]

    for idx in range(len(sequence)):
        if rotated_sequence[idx] != ordered_sequence[idx]:
            return False

    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [],
        [1],
        [2, 1],
        [3, 2, 1],
        [1, 2, 3],
        [4, 5, 6, 1, 2, 3],
        [2, 3, 4, 5, 6, 1],
        [1, 3, 2],
        [5, 1, 2, 3, 4],
        [10, 20, 30, 40, 50]
    ]

    def test_0(self):
        self.assertEqual(move_one_ball(self.test_cases[0]), check_sorted_after_rotation(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(move_one_ball(self.test_cases[1]), check_sorted_after_rotation(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(move_one_ball(self.test_cases[2]), check_sorted_after_rotation(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(move_one_ball(self.test_cases[3]), check_sorted_after_rotation(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(move_one_ball(self.test_cases[4]), check_sorted_after_rotation(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(move_one_ball(self.test_cases[5]), check_sorted_after_rotation(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(move_one_ball(self.test_cases[6]), check_sorted_after_rotation(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(move_one_ball(self.test_cases[7]), check_sorted_after_rotation(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(move_one_ball(self.test_cases[8]), check_sorted_after_rotation(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(move_one_ball(self.test_cases[9]), check_sorted_after_rotation(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()