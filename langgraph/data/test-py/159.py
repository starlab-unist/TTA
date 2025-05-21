def eat(number, need, remaining):
    if(need <= remaining):
        return [ number + need , remaining-need ]
    else:
        return [ number + remaining , 0]

def consume(quantity, requirement, stock):
    if requirement <= stock:
        updated_quantity = quantity + requirement
        leftover_stock = stock - requirement
    else:
        updated_quantity = quantity + stock
        leftover_stock = 0

    return [updated_quantity, leftover_stock]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (10, 5, 8),
        (20, 15, 10),
        (0, 0, 0),
        (1, 2, 3),
        (5, 5, 5),
        (100, 50, 75),
        (42, 99, 10),
        (7, 0, 5),
        (3, 3, 2),
        (8, 10, 8)
    ]

    def test_0(self):
        self.assertEqual(eat(*self.test_cases[0]), consume(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(eat(*self.test_cases[1]), consume(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(eat(*self.test_cases[2]), consume(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(eat(*self.test_cases[3]), consume(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(eat(*self.test_cases[4]), consume(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(eat(*self.test_cases[5]), consume(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(eat(*self.test_cases[6]), consume(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(eat(*self.test_cases[7]), consume(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(eat(*self.test_cases[8]), consume(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(eat(*self.test_cases[9]), consume(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()