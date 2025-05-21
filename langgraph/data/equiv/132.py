def check_for_nesting(expression):
    start_brackets_positions = []
    end_brackets_positions = []
    index = 0
    while index < len(expression):
        if expression[index] == '[':
            start_brackets_positions.append(index)
        else:
            end_brackets_positions.append(index)
        index += 1
    end_brackets_positions.reverse()
    match_count = 0
    j = 0
    total_end_brackets = len(end_brackets_positions)
    for open_pos in start_brackets_positions:
        if j < total_end_brackets and open_pos < end_brackets_positions[j]:
            match_count += 1
            j += 1
    return match_count >= 2

# method name: is_nested -> check_for_nesting
# parameter name: string -> expression
# variable name: opening_bracket_index -> start_brackets_positions, closing_bracket_index -> end_brackets_positions
# changed for loop to while loop
# used index instead of i for clarity in the while loop
# renamed cnt to match_count and l to total_end_brackets for better readability