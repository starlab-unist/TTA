def calculate_midpoint(values: list):
    sorted_values = sorted(values)
    midpoint_index = len(sorted_values) // 2

    if len(sorted_values) % 2 == 1:
        return sorted_values[midpoint_index]
    else:
        return (sorted_values[midpoint_index - 1] + sorted_values[midpoint_index]) / 2.0

# method name: median -> calculate_midpoint
# parameter name: l -> values
# variable name: l -> sorted_values, len(l) // 2 -> midpoint_index
# used a separate variable for the midpoint index to avoid repetition