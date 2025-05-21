def common(l1: list, l2: list):
    ret = set()
    for e1 in l1:
        for e2 in l2:
            if e1 == e2:
                ret.add(e1)
    return sorted(list(ret))


def find_shared_elements(list_a: list, list_b: list):
    shared_items = set()
    iterator_a = iter(list_a)
    
    while True:
        try:
            element_a = next(iterator_a)
            for element_b in list_b:
                if element_a == element_b:
                    shared_items.add(element_a)
        except StopIteration:
            break
    
    return sorted(list(shared_items))


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3], [2, 3, 4]),
        (['a', 'b', 'c'], ['b', 'c', 'd']),
        ([10, 20, 30], [40, 50, 60]),
        ([], []),
        ([1, 1, 2, 2], [2, 2, 3, 3]),
        (['apple', 'banana'], ['banana', 'orange']),
        ([True, False], [False, True]),
        (['x', 'y', 'z'], ['a', 'b', 'c']),
        ([1, 2, 3, 4, 5], [3, 4, 5, 6, 7]),
        ([None, None, None], [None])
    ]

    def test_0(self):
        self.assertEqual(common(self.test_cases[0][0], self.test_cases[0][1]), find_shared_elements(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(common(self.test_cases[1][0], self.test_cases[1][1]), find_shared_elements(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(common(self.test_cases[2][0], self.test_cases[2][1]), find_shared_elements(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(common(self.test_cases[3][0], self.test_cases[3][1]), find_shared_elements(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(common(self.test_cases[4][0], self.test_cases[4][1]), find_shared_elements(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(common(self.test_cases[5][0], self.test_cases[5][1]), find_shared_elements(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(common(self.test_cases[6][0], self.test_cases[6][1]), find_shared_elements(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(common(self.test_cases[7][0], self.test_cases[7][1]), find_shared_elements(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(common(self.test_cases[8][0], self.test_cases[8][1]), find_shared_elements(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(common(self.test_cases[9][0], self.test_cases[9][1]), find_shared_elements(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()