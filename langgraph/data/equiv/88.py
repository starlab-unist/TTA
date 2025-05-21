def arrange_sequence(sequence):
    if not sequence:
        return []
    
    reverse_order = (sequence[0] + sequence[-1]) % 2 == 0
    return sorted(sequence, reverse=reverse_order)

# method name: sort_array -> arrange_sequence
# parameter name: array -> sequence
# replaced the ternary operator with an if statement for clarity
# used a separate variable reverse_order to store the boolean value