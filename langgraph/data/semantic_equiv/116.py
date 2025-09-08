def arrange_numbers_by_binary_ones(numbers):
    def count_ones_in_binary(num):
        return bin(num).count('1')

    sorted_numbers = sorted(numbers)
    final_sorted_numbers = sorted(sorted_numbers, key=count_ones_in_binary)

    return final_sorted_numbers
# method name: sort_array -> arrange_numbers_by_binary_ones
# parameter name: arr -> numbers
# introduced a helper function count_ones_in_binary to count '1's in binary representation
# split the sorting process into two steps for clarity
# used the helper function in the second sort call