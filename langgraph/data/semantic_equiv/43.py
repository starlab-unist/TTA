def contains_zero_sum_pair(numbers):
    index = 0
    while index < len(numbers):
        inner_index = index + 1
        while inner_index < len(numbers):
            if numbers[index] + numbers[inner_index] == 0:
                return True
            inner_index += 1
        index += 1
    return False

# method name: pairs_sum_to_zero -> contains_zero_sum_pair
# parameter name: l -> numbers
# changed for loops to while loops
# renamed loop variables: i -> index, j -> inner_index