def find_top_k_elements(sequence, count):
    if count == 0:
        return []

    sorted_sequence = sorted(sequence)
    top_elements = sorted_sequence[-count:]

    return top_elements

# method name: maximum -> find_top_k_elements
# parameter name: arr -> sequence, k -> count
# replaced arr.sort() with sorted(sequence) to avoid modifying the original list
# variable name: ans -> top_elements