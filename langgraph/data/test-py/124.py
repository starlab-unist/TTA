def valid_date(date):
    try:
        date = date.strip()
        month, day, year = date.split('-')
        month, day, year = int(month), int(day), int(year)
        if month < 1 or month > 12:
            return False
        if month in [1,3,5,7,8,10,12] and day < 1 or day > 31:
            return False
        if month in [4,6,9,11] and day < 1 or day > 30:
            return False
        if month == 2 and day < 1 or day > 29:
            return False
    except:
        return False

    return True

def check_valid_date(d):
    try:
        d = d.strip()
        m, d, y = map(int, d.split('-'))
        
        if not (1 <= m <= 12):
            return False
        
        if m in {1, 3, 5, 7, 8, 10, 12} and not (1 <= d <= 31):
            return False
        
        if m in {4, 6, 9, 11} and not (1 <= d <= 30):
            return False
        
        if m == 2 and not (1 <= d <= 29):
            return False
    
    except ValueError:
        return False

    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "01-15-2023",   # valid date
        "02-29-2024",   # valid leap year date
        "04-31-2023",   # invalid date, April has 30 days
        "13-01-2023",   # invalid month
        "00-10-2023",   # invalid month
        "06-00-2023",   # invalid day
        "06-32-2023",   # invalid day
        "02-30-2023",   # invalid date, February has 29 days in a leap year
        "-1-15-2023",   # invalid format
        "01--15-2023",  # invalid format
    ]

    def test_0(self):
        self.assertEqual(valid_date(self.test_cases[0]), check_valid_date(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(valid_date(self.test_cases[1]), check_valid_date(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(valid_date(self.test_cases[2]), check_valid_date(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(valid_date(self.test_cases[3]), check_valid_date(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(valid_date(self.test_cases[4]), check_valid_date(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(valid_date(self.test_cases[5]), check_valid_date(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(valid_date(self.test_cases[6]), check_valid_date(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(valid_date(self.test_cases[7]), check_valid_date(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(valid_date(self.test_cases[8]), check_valid_date(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(valid_date(self.test_cases[9]), check_valid_date(self.test_cases[9]))

if __name__ == "__main__":
    unittest.main()