from typing import List


def merge_strings(string_list: List[str]) -> str:
    result = ""
    index = 0
    while index < len(string_list):
        result += string_list[index]
        index += 1
    return result
# method name: concatenate -> merge_strings
# parameter name: strings -> string_list
# replaced ''.join(strings) with a while loop to concatenate strings manually