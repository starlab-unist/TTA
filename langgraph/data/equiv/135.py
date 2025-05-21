def find_first_decrease_index(sequence):
    position = -1
    index = 1
    while index < len(sequence):
        if sequence[index] < sequence[index - 1]:
            position = index
        index += 1
    return position

# method name: can_arrange -> find_first_decrease_index
# parameter name: arr -> sequence
# variable name: ind -> position, i -> index
# kept the same logic and structure but changed identifiers and added comments for clarity