def find_second_minimum(numbers):
    unique_numbers = list(sorted(set(numbers)))

    if len(unique_numbers) < 2:
        return None

    return unique_numbers[1]
# method name: next_smallest -> find_second_minimum
# parameter name: lst -> numbers
# variable name: lst -> unique_numbers
# replaced set conversion and sorting in one line to two separate lines for clarity
# used if statement with explicit condition for better readability