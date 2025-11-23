from typing import List

def extract_substring_matches(input_texts: List[str], pattern: str) -> List[str]:
    filtered_collection = []
    for entry in input_texts:
        if pattern in entry:
            filtered_collection.append(entry)
    return filtered_collection
# method name: filter_by_substring → extract_substring_matches
# parameter names: strings → input_texts, substring → pattern
# replaced list comprehension with explicit for-loop
# variable names changed: x → entry, result list → filtered_collection