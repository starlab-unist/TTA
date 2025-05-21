def calculate_sum_of_small_numbers(numbers, count):
    total = 0
    index = 0
    
    while index < count and index < len(numbers):
        if len(str(numbers[index])) <= 2:
            total += numbers[index]
        index += 1
    
    return total

# method name: add_elements -> calculate_sum_of_small_numbers
# parameter name: arr -> numbers, k -> count
# replaced list comprehension with while loop and if condition
# added explicit index handling and length check to avoid index errors
# used a running total variable instead of summing in a single line