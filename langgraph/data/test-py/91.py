import re

# Source Code
def is_bored(S):
    import re
    sentences = re.split(r'[.?!]\s*', S)
    return sum(sentence[0:2] == 'I ' for sentence in sentences)

# Transformed Code (Semantically Equivalent)
import re

def count_personal_statements(text):
    segments = re.split(r'[.?!]\s*', text)
    personal_statement_count = 0

    for segment in segments:
        if segment.startswith('I '):
            personal_statement_count += 1

    return personal_statement_count

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "I am bored. I think so.",
        "This is a test. I am testing.",
        "Hello world! I am here. Are you there?",
        "No personal statements here.",
        "I I I. I? I!",
        "I am fine. You are fine.",
        "I",
        "",
        "I am alone.I think so.I am sad.",
        "I. I! I?"
    ]

    def test_0(self):
        self.assertEqual(is_bored(self.test_cases[0]), count_personal_statements(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_bored(self.test_cases[1]), count_personal_statements(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_bored(self.test_cases[2]), count_personal_statements(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_bored(self.test_cases[3]), count_personal_statements(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_bored(self.test_cases[4]), count_personal_statements(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_bored(self.test_cases[5]), count_personal_statements(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_bored(self.test_cases[6]), count_personal_statements(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_bored(self.test_cases[7]), count_personal_statements(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_bored(self.test_cases[8]), count_personal_statements(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_bored(self.test_cases[9]), count_personal_statements(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()