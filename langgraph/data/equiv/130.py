def generate_custom_sequence(length):
    if length == 0:
        return [1]
    
    sequence = [1, 3]
    index = 2
    
    while index <= length:
        if index % 2 == 0:
            sequence.append(index / 2 + 1)
        else:
            sequence.append(sequence[index - 1] + sequence[index - 2] + (index + 3) / 2)
        index += 1
    
    return sequence

# method name: tri -> generate_custom_sequence
# parameter name: n -> length
# variable name: my_tri -> sequence, i -> index
# changed for loop to while loop
# kept the same logic for appending values to the list