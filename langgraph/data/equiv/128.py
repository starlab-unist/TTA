def calculate_signed_sum(numbers):
    if not numbers:
        return None
    
    negative_count = sum(1 for num in numbers if num < 0)
    contains_zero = any(num == 0 for num in numbers)
    
    sign = 0 if contains_zero else (-1) ** negative_count
    total_sum = sum(abs(num) for num in numbers)
    
    return sign * total_sum

# method name: prod_signs -> calculate_signed_sum
# parameter name: arr -> numbers
# variable name: prod -> sign, used a more descriptive name
# replaced filter and lambda with a generator expression for negative count
# replaced list comprehension with sum and generator expression for total_sum
# changed the logic to use any() for checking zero presence
# kept the overall logic but restructured the code for clarity