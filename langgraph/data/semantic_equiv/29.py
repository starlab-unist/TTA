from typing import List

def select_strings_with_prefix(word_list: List[str], start_sequence: str) -> List[str]:
    result = []
    index = 0
    while index < len(word_list):
        if word_list[index].startswith(start_sequence):
            result.append(word_list[index])
        index += 1
    return result

# method name: filter_by_prefix -> select_strings_with_prefix
# parameter name: strings -> word_list, prefix -> start_sequence
# changed list comprehension to while loop for iteration
# used a result list to accumulate matching strings