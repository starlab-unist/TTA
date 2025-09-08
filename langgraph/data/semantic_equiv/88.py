def arrange_sequence(sequence):
    if not sequence:
        return []
    
    reverse_flag = (sequence[0] + sequence[-1]) % 2 == 0
    return sorted(sequence, reverse=reverse_flag)

# method name: sort_array -> arrange_sequence
# parameter name: array -> sequence
# changed the condition to `if not sequence:` for checking empty list
# extracted the reverse condition into a variable `reverse_flag` for clarity
# used the `sorted` function with the `reverse` parameter directly