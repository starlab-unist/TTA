def file_name_check(file_name):
    suf = ['txt', 'exe', 'dll']
    lst = file_name.split(sep='.')
    if len(lst) != 2:
        return 'No'
    if not lst[1] in suf:
        return 'No'
    if len(lst[0]) == 0:
        return 'No'
    if not lst[0][0].isalpha():
        return 'No'
    t = len([x for x in lst[0] if x.isdigit()])
    if t > 3:
        return 'No'
    return 'Yes'

def validate_filename(filename):
    valid_extensions = ['txt', 'exe', 'dll']
    parts = filename.split('.')

    if len(parts) != 2:
        return 'No'
    
    extension, name = parts[1], parts[0]
    
    if extension not in valid_extensions:
        return 'No'
    
    if not name:
        return 'No'
    
    if not name[0].isalpha():
        return 'No'
    
    digit_count = sum(1 for char in name if char.isdigit())
    
    if digit_count > 3:
        return 'No'
    
    return 'Yes'

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "example.txt",
        "test.exe",
        "data.dll",
        "file..txt",
        ".hiddenfile.txt",
        "1234name.txt",
        "validName123.exe",
        "anotherValid.dll",
        "tooManyDigits1234.txt",
        "noextension",
        "wrongextension.doc"
    ]

    def test_0(self):
        self.assertEqual(file_name_check(self.test_cases[0]), validate_filename(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(file_name_check(self.test_cases[1]), validate_filename(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(file_name_check(self.test_cases[2]), validate_filename(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(file_name_check(self.test_cases[3]), validate_filename(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(file_name_check(self.test_cases[4]), validate_filename(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(file_name_check(self.test_cases[5]), validate_filename(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(file_name_check(self.test_cases[6]), validate_filename(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(file_name_check(self.test_cases[7]), validate_filename(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(file_name_check(self.test_cases[8]), validate_filename(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(file_name_check(self.test_cases[9]), validate_filename(self.test_cases[9]))
        
    def test_10(self):
        self.assertEqual(file_name_check(self.test_cases[10]), validate_filename(self.test_cases[10]))

if __name__ == '__main__':
    unittest.main()