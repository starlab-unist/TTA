def minimal_adjustments(sequence):
    adjustments_needed = 0
    index = 0
    while index < len(sequence) // 2:
        if sequence[index] != sequence[-index - 1]:
            adjustments_needed += 1
        index += 1
    return adjustments_needed

# method name: smallest_change -> minimal_adjustments
# parameter name: arr -> sequence
# variable name: ans -> adjustments_needed
# changed for loop to while loop
# used negative indexing for comparison