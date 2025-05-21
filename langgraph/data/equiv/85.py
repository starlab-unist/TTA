def calculate_even_sum_at_odd_indices(numbers):
    total = 0
    index = 1
    while index < len(numbers):
        if numbers[index] % 2 == 0:
            total += numbers[index]
        index += 2
    return total

# method name: add -> calculate_even_sum_at_odd_indices
# parameter name: lst -> numbers
# replaced list comprehension with while loop and if condition
# changed sum calculation to manual accumulation using a total variable