def find_extreme_values(numbers):
    negative_numbers = [num for num in numbers if num < 0]
    positive_numbers = [num for num in numbers if num > 0]

    max_negative = max(negative_numbers) if negative_numbers else None
    min_positive = min(positive_numbers) if positive_numbers else None

    return (max_negative, min_positive)
# method name: largest_smallest_integers -> find_extreme_values
# parameter name: lst -> numbers
# replaced filter with list comprehension for negative and positive numbers
# used max() and min() directly on the lists with conditional expressions
# maintained the return tuple structure