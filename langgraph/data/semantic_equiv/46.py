def calculate_custom_fibonacci(m: int):
    sequence = [0, 0, 2, 0]
    if m < 4:
        return sequence[m]

    index = 4
    while index <= m:
        next_value = sequence[-1] + sequence[-2] + sequence[-3] + sequence[-4]
        sequence.append(next_value)
        sequence.pop(0)
        index += 1

    return sequence[-1]

# method name: fib4 -> calculate_custom_fibonacci
# parameter name: n -> m
# variable name: results -> sequence
# changed for loop to while loop with index
# added index variable to control the loop