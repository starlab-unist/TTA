def find_top_k_elements(sequence, num_elements):
    if num_elements == 0:
        return []

    sorted_sequence = sorted(sequence)
    top_elements = sorted_sequence[-num_elements:]

    return top_elements
# method name: maximum -> find_top_k_elements
# parameter name: arr -> sequence, k -> num_elements
# replaced arr.sort() with sorted(sequence) to avoid modifying the original list
# variable name: ans -> top_elements
# kept the logic of slicing the last k elements but used a new variable name