def check_for_zero_sum_pairs(numbers):
    index = 0
    while index < len(numbers):
        current_number = numbers[index]
        next_index = index + 1
        while next_index < len(numbers):
            if current_number + numbers[next_index] == 0:
                return True
            next_index += 1
        index += 1
    return False

# method name: pairs_sum_to_zero -> check_for_zero_sum_pairs
# parameter name: l -> numbers
# outer loop changed from for to while
# inner loop changed from for to while
# variable names changed: i -> index, l1 -> current_number, j -> next_index