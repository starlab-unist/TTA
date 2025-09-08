from typing import List, Optional

def find_longest_string(string_list: List[str]) -> Optional[str]:
    if not string_list:
        return None

    max_length = max(map(len, string_list))
    iterator = iter(string_list)
    current_string = next(iterator)

    while len(current_string) != max_length:
        current_string = next(iterator)

    return current_string

# method name: longest -> find_longest_string
# parameter name: strings -> string_list
# variable name: maxlen -> max_length
# replaced list comprehension with map for max calculation
# replaced for loop with while loop and iterator