def calculate_custom_fibonacci(index: int):
    sequence = [0, 0, 2, 0]
    if index < 4:
        return sequence[index]

    current_index = 4
    while current_index <= index:
        next_value = sequence[-1] + sequence[-2] + sequence[-3] + sequence[-4]
        sequence.append(next_value)
        sequence.pop(0)
        current_index += 1

    return sequence[-1]

# method name: fib4 -> calculate_custom_fibonacci
# parameter name: n -> index
# variable name: results -> sequence
# replaced for loop with while loop
# introduced current_index to track the loop progress
# kept the logic of appending and popping elements in the list to maintain constant size