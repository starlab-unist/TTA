def validate_bracket_sequence(sequence: str):
    level = 0
    index = 0
    while index < len(sequence):
        if sequence[index] == "<":
            level += 1
        else:
            level -= 1
        if level < 0:
            return False
        index += 1
    return level == 0

# method name: correct_bracketing -> validate_bracket_sequence
# parameter name: brackets -> sequence
# variable name: depth -> level, b -> (removed, using indexing instead)
# changed for loop to while loop with index
# kept the same logic and return conditions