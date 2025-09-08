def calculate_sum_of_small_numbers(numbers, limit):
    total = 0
    index = 0

    while index < limit and index < len(numbers):
        if len(str(numbers[index])) <= 2:
            total += numbers[index]
        index += 1

    return total
# method name: add_elements -> calculate_sum_of_small_numbers
# parameter name: arr -> numbers, k -> limit
# changed list comprehension to a while loop for summation
# added check to prevent index out of range error
# used a variable `total` to accumulate the sum