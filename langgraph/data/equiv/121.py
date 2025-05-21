def calculate_odd_sum_at_even_indices(numbers):
    total = 0
    index = 0
    while index < len(numbers):
        if index % 2 == 0 and numbers[index] % 2 == 1:
            total += numbers[index]
        index += 1
    return total

# method name: solution -> calculate_odd_sum_at_even_indices
# parameter name: lst -> numbers
# replaced list comprehension with while loop and if condition
# used a manual sum calculation instead of sum() on a list comprehension