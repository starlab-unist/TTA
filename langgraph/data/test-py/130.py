def tri(n):
    if n == 0:
        return [1]
    my_tri = [1, 3]
    for i in range(2, n + 1):
        if i % 2 == 0:
            my_tri.append(i / 2 + 1)
        else:
            my_tri.append(my_tri[i - 1] + my_tri[i - 2] + (i + 3) / 2)
    return my_tri

def generate_custom_sequence(length):
    if length == 0:
        return [1]
    
    sequence = [1, 3]
    index = 2
    
    while index <= length:
        if index % 2 == 0:
            sequence.append(index / 2 + 1)
        else:
            sequence.append(sequence[index - 1] + sequence[index - 2] + (index + 3) / 2)
        index += 1
    
    return sequence

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    ]

    def test_0(self):
        self.assertEqual(tri(self.test_cases[0]), generate_custom_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(tri(self.test_cases[1]), generate_custom_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(tri(self.test_cases[2]), generate_custom_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(tri(self.test_cases[3]), generate_custom_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(tri(self.test_cases[4]), generate_custom_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(tri(self.test_cases[5]), generate_custom_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(tri(self.test_cases[6]), generate_custom_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(tri(self.test_cases[7]), generate_custom_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(tri(self.test_cases[8]), generate_custom_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(tri(self.test_cases[9]), generate_custom_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()