def will_it_fly(q, w):
    if sum(q) > w:
        return False

    i, j = 0, len(q) - 1
    while i < j:
        if q[i] != q[j]:
            return False
        i += 1
        j -= 1
    return True


def can_it_take_off(weights, max_weight):
    total_weight = sum(weights)

    if total_weight > max_weight:
        return False

    start, end = 0, len(weights) - 1
    while start < end:
        if weights[start] != weights[end]:
            return False
        start += 1
        end -= 1

    return True


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3, 2, 1], 10),
        ([1, 2, 3, 4, 5], 15),
        ([1, 1, 1, 1], 4),
        ([1, 2, 2, 1], 6),
        ([1], 1),
        ([], 0),
        ([5, 5, 5, 5], 20),
        ([5, 5, 5, 5], 19),
        ([1, 2, 3, 4, 3, 2, 1], 20),
        ([1, 2, 3, 4, 5, 6, 7], 28)
    ]

    def test_0(self):
        self.assertEqual(will_it_fly(*self.test_cases[0]), can_it_take_off(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(will_it_fly(*self.test_cases[1]), can_it_take_off(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(will_it_fly(*self.test_cases[2]), can_it_take_off(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(will_it_fly(*self.test_cases[3]), can_it_take_off(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(will_it_fly(*self.test_cases[4]), can_it_take_off(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(will_it_fly(*self.test_cases[5]), can_it_take_off(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(will_it_fly(*self.test_cases[6]), can_it_take_off(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(will_it_fly(*self.test_cases[7]), can_it_take_off(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(will_it_fly(*self.test_cases[8]), can_it_take_off(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(will_it_fly(*self.test_cases[9]), can_it_take_off(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()