def even_length_sorted_elements(sequence):
    sequence.sort()
    filtered_sequence = [element for element in sequence if len(element) % 2 == 0]
    return sorted(filtered_sequence, key=len)

# method name: sorted_list_sum -> even_length_sorted_elements
# parameter name: lst -> sequence
# replaced for loop with list comprehension
# variable name: new_lst -> filtered_sequence
# kept the overall logic but changed syntax and structure