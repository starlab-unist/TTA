def make_a_pile(n):
    return [n + 2*i for i in range(n)]

def construct_stack(size):
    pile = []
    index = 0
    while index < size:
        pile.append(size + 2 * index)
        index += 1
    return pile

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    ]

    def test_0(self):
        self.assertEqual(make_a_pile(self.test_cases[0]), construct_stack(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(make_a_pile(self.test_cases[1]), construct_stack(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(make_a_pile(self.test_cases[2]), construct_stack(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(make_a_pile(self.test_cases[3]), construct_stack(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(make_a_pile(self.test_cases[4]), construct_stack(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(make_a_pile(self.test_cases[5]), construct_stack(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(make_a_pile(self.test_cases[6]), construct_stack(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(make_a_pile(self.test_cases[7]), construct_stack(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(make_a_pile(self.test_cases[8]), construct_stack(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(make_a_pile(self.test_cases[9]), construct_stack(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()