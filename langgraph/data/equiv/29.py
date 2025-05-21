from typing import List

def select_strings_with_starting_chars(word_list: List[str], start_sequence: str) -> List[str]:
    filtered_words = []
    for word in word_list:
        if word.startswith(start_sequence):
            filtered_words.append(word)
    return filtered_words

# method name: filter_by_prefix -> select_strings_with_starting_chars
# parameter name: strings -> word_list, prefix -> start_sequence
# changed list comprehension to for loop with append
# variable name: x -> word, result -> filtered_words