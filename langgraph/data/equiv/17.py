from typing import List


def extract_notes(musical_notation: str) -> List[int]:
    note_mapping = {'o': 4, 'o|': 2, '.|': 1}
    notes = musical_notation.split(' ')
    result = []

    for note in notes:
        if note:
            result.append(note_mapping[note])

    return result
# method name: parse_music -> extract_notes
# parameter name: music_string -> musical_notation
# variable name: note_map -> note_mapping, x -> note
# replaced list comprehension with for loop and if condition