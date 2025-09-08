from typing import List


def partition_parentheses(input_sequence: str) -> List[str]:
    grouped_parens = []
    temp_group = []
    nesting_level = 0

    index = 0
    while index < len(input_sequence):
        character = input_sequence[index]
        if character == '(':
            nesting_level += 1
            temp_group.append(character)
        elif character == ')':
            nesting_level -= 1
            temp_group.append(character)

            if nesting_level == 0:
                grouped_parens.append(''.join(temp_group))
                temp_group.clear()
        
        index += 1

    return grouped_parens

# method name: separate_paren_groups -> partition_parentheses
# parameter name: paren_string -> input_sequence
# variable name: result -> grouped_parens, current_string -> temp_group, current_depth -> nesting_level
# replaced for loop with while loop and index increment
# used ''.join(temp_group) instead of direct list to string conversion