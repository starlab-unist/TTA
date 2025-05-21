def check_happiness(sequence):
    if len(sequence) < 3:
        return False

    index = 0
    while index < len(sequence) - 2:
        if sequence[index] == sequence[index + 1] or \
           sequence[index + 1] == sequence[index + 2] or \
           sequence[index] == sequence[index + 2]:
            return False
        index += 1

    return True

# method name: is_happy -> check_happiness
# parameter name: s -> sequence
# changed for loop to while loop
# used backslashes for line continuation in the if statement
# incremented index manually within the while loop