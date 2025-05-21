from typing import List, Optional

def find_longest_string(string_list: List[str]) -> Optional[str]:
    if not string_list:
        return None

    max_length = max((len(item) for item in string_list))
    for element in string_list:
        if len(element) == max_length:
            return element

# method name: longest -> find_longest_string
# parameter name: strings -> string_list
# variable name: maxlen -> max_length, s -> element
# used generator expression for max calculation to maintain consistency