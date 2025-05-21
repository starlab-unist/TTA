from typing import List
import unittest


# Source Code
def parse_music(music_string: str) -> List[int]:
    note_map = {'o': 4, 'o|': 2, '.|': 1}
    return [note_map[x] for x in music_string.split(' ') if x]


# Transformed Code (Semantically Equivalent)
def extract_notes(musical_notation: str) -> List[int]:
    note_mapping = {'o': 4, 'o|': 2, '.|': 1}
    notes = musical_notation.split(' ')
    result = []

    for note in notes:
        if note:
            result.append(note_mapping[note])

    return result


# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "o o| .|",
        "o o o",
        ".| .| .|",
        "o| o| o|",
        "o o| .| o| .|",
        "",
        "   ",
        "o o| .| o| .| o o| .|",
        "o|",
        "o"
    ]

    def test_0(self):
        self.assertEqual(parse_music(self.test_cases[0]), extract_notes(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(parse_music(self.test_cases[1]), extract_notes(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(parse_music(self.test_cases[2]), extract_notes(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(parse_music(self.test_cases[3]), extract_notes(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(parse_music(self.test_cases[4]), extract_notes(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(parse_music(self.test_cases[5]), extract_notes(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(parse_music(self.test_cases[6]), extract_notes(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(parse_music(self.test_cases[7]), extract_notes(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(parse_music(self.test_cases[8]), extract_notes(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(parse_music(self.test_cases[9]), extract_notes(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()