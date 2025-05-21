def alternate_sort_sequence(sequence):
    result, toggle = [], True
    while sequence:
        selected_value = min(sequence) if toggle else max(sequence)
        result.append(selected_value)
        sequence.remove(selected_value)
        toggle = not toggle
    return result

# method name: strange_sort_list -> alternate_sort_sequence
# parameter name: lst -> sequence
# variable name: res -> result, switch -> toggle
# replaced inline conditional with a separate line for clarity
# kept the core logic of alternating between min and max