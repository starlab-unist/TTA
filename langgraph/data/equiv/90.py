def find_second_minimum(numbers):
    unique_numbers = sorted(list(set(numbers)))

    if len(unique_numbers) < 2:
        return None

    return unique_numbers[1]
# method name: next_smallest -> find_second_minimum
# parameter name: lst -> numbers
# variable name: lst -> unique_numbers
# used list(set(numbers)) instead of set(lst) to emphasize list conversion
# expanded the return statement for clarity