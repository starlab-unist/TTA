# Original Function
def numerical_letter_grade(grades):
    letter_grade = []
    for gpa in grades:
        if gpa == 4.0:
            letter_grade.append("A+")
        elif gpa > 3.7:
            letter_grade.append("A")
        elif gpa > 3.3:
            letter_grade.append("A-")
        elif gpa > 3.0:
            letter_grade.append("B+")
        elif gpa > 2.7:
            letter_grade.append("B")
        elif gpa > 2.3:
            letter_grade.append("B-")
        elif gpa > 2.0:
            letter_grade.append("C+")
        elif gpa > 1.7:
            letter_grade.append("C")
        elif gpa > 1.3:
            letter_grade.append("C-")
        elif gpa > 1.0:
            letter_grade.append("D+")
        elif gpa > 0.7:
            letter_grade.append("D")
        elif gpa > 0.0:
            letter_grade.append("D-")
        else:
            letter_grade.append("E")
    return letter_grade


# Transformed Function
def convert_gpas_to_letter_grades(gpa_list):
    grade_map = {
        (4.0,): "A+",
        (3.7, 4.0): "A",  # Corrected this line and all others below
        (3.3, 3.7): "A-",
        (3.0, 3.3): "B+",
        (2.7, 3.0): "B",
        (2.3, 2.7): "B-",
        (2.0, 2.3): "C+",
        (1.7, 2.0): "C",
        (1.3, 1.7): "C-",
        (1.0, 1.3): "D+",
        (0.7, 1.0): "D",
        (0.0, 0.7): "D-"
    }

    letter_grades = []
    for gpa in gpa_list:
        for grade_range, letter in grade_map.items():
            if isinstance(grade_range, tuple):
                lower, upper = grade_range
                if lower < gpa <= upper:
                    letter_grades.append(letter)
                    break
            else:  # For the exact match of 4.0
                if gpa == lower:
                    letter_grades.append(letter)
                    break

    return letter_grades


# Test Cases
import unittest

class TestGPAConversion(unittest.TestCase):
    def test_numerical_letter_grade(self):
        self.assertEqual(numerical_letter_grade([4.0]), ["A+"])
        self.assertEqual(numerical_letter_grade([3.8]), ["A"])
        self.assertEqual(numerical_letter_grade([3.5]), ["A-"])
        self.assertEqual(numerical_letter_grade([3.2]), ["B+"])
        self.assertEqual(numerical_letter_grade([2.9]), ["B"])
        self.assertEqual(numerical_letter_grade([2.5]), ["B-"])
        self.assertEqual(numerical_letter_grade([2.1]), ["C+"])
        self.assertEqual(numerical_letter_grade([1.8]), ["C"])
        self.assertEqual(numerical_letter_grade([1.4]), ["C-"])
        self.assertEqual(numerical_letter_grade([1.1]), ["D+"])
        self.assertEqual(numerical_letter_grade([0.8]), ["D"])
        self.assertEqual(numerical_letter_grade([0.3]), ["D-"])
        self.assertEqual(numerical_letter_grade([0.0]), ["D-"])

    def test_convert_gpas_to_letter_grades(self):
        self.assertEqual(convert_gpas_to_letter_grades([4.0]), ["A+"])
        self.assertEqual(convert_gpas_to_letter_grades([3.8]), ["A"])
        self.assertEqual(convert_gpas_to_letter_grades([3.5]), ["A-"])
        self.assertEqual(convert_gpas_to_letter_grades([3.2]), ["B+"])
        self.assertEqual(convert_gpas_to_letter_grades([2.9]), ["B"])
        self.assertEqual(convert_gpas_to_letter_grades([2.5]), ["B-"])
        self.assertEqual(convert_gpas_to_letter_grades([2.1]), ["C+"])
        self.assertEqual(convert_gpas_to_letter_grades([1.8]), ["C"])
        self.assertEqual(convert_gpas_to_letter_grades([1.4]), ["C-"])
        self.assertEqual(convert_gpas_to_letter_grades([1.1]), ["D+"])
        self.assertEqual(convert_gpas_to_letter_grades([0.8]), ["D"])
        self.assertEqual(convert_gpas_to_letter_grades([0.3]), ["D-"])
        self.assertEqual(convert_gpas_to_letter_grades([0.0]), ["D-"])

if __name__ == '__main__':
    unittest.main()