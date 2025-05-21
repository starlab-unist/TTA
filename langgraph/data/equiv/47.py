def calculate_median(numbers: list):
    sorted_numbers = sorted(numbers)
    mid_index = len(sorted_numbers) // 2
    
    if len(sorted_numbers) % 2 == 1:
        return sorted_numbers[mid_index]
    else:
        return (sorted_numbers[mid_index - 1] + sorted_numbers[mid_index]) / 2.0

# method name: median -> calculate_median
# parameter name: l -> numbers
# variable name: l -> sorted_numbers, len(l) // 2 -> mid_index
# replaced direct indexing with mid_index variable for clarity