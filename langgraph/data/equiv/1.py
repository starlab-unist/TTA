from typing import List


def extract_balanced_parentheses(input_sequence: str) -> List[str]:
    output_groups = []
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
                output_groups.append(''.join(temp_group))
                temp_group = []

        index += 1

    return output_groups

# method name: separate_paren_groups -> extract_balanced_parentheses
# parameter name: paren_string -> input_sequence
# variable name: result -> output_groups, current_string -> temp_group, current_depth -> nesting_level
# replaced for loop with while loop and index increment
# used ''.join(temp_group) directly in append statement