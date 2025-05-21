from typing import List


def extract_matching_strings(sequence: List[str], pattern: str) -> List[str]:
    result = []
    index = 0
    while index < len(sequence):
        if pattern in sequence[index]:
            result.append(sequence[index])
        index += 1
    return result
# method name: filter_by_substring -> extract_matching_strings
# parameter name: strings -> sequence, substring -> pattern
# changed list comprehension to while loop for iteration
# introduced an explicit result list to append matching strings