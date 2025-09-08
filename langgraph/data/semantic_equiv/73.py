def minimal_modifications(sequence):
    modifications = 0
    index = 0
    while index < len(sequence) // 2:
        if sequence[index] != sequence[-index - 1]:
            modifications += 1
        index += 1
    return modifications

# method name: smallest_change -> minimal_modifications
# parameter name: arr -> sequence
# variable name: ans -> modifications, i -> index
# changed for loop to while loop
# used negative indexing for comparison