from typing import List


def generate_string_prefixes(input_str: str) -> List[str]:
    prefixes = []
    index = 0

    while index < len(input_str):
        prefixes.append(input_str[:index + 1])
        index += 1

    return prefixes

# method name: all_prefixes -> generate_string_prefixes
# parameter name: string -> input_str
# variable name: result -> prefixes
# changed for loop to while loop
# added index variable to keep track of the loop progress