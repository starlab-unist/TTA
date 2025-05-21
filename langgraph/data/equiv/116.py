def arrange_by_binary_ones(sequence):
    def count_ones_in_binary(number):
        return bin(number).count('1')
    
    return sorted(sorted(sequence), key=count_ones_in_binary)

# method name: sort_array -> arrange_by_binary_ones
# parameter name: arr -> sequence
# introduced a helper function count_ones_in_binary to count '1's in binary representation
# used the helper function in the key argument of the sorted function