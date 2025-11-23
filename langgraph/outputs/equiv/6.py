from typing import List

def get_parenthesis_nesting_levels(parens_input: str) -> List[int]:
    def calculate_max_depth(segment: str) -> int:
        current_level = 0
        highest_level = 0
        for char in segment:
            if char == '(':
                current_level += 1
                if current_level > highest_level:
                    highest_level = current_level
            else:
                current_level -= 1
        return highest_level

    parts = parens_input.split(' ')
    output = []
    for group in parts:
        if group:
            output.append(calculate_max_depth(group))
    return output

# method name: parse_nested_parens → get_parenthesis_nesting_levels
# parameter name: paren_string → parens_input
# helper function: parse_paren_group → calculate_max_depth
# variable names: depth → current_level, max_depth → highest_level
# control structure: list comprehension → explicit for loop
# replaced max() with conditional update for highest_level
# changed segment processing to use 'group' instead of 'x'