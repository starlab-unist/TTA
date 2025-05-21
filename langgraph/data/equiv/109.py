def check_sorted_after_rotation(sequence):
    if not sequence:
        return True

    ordered_sequence = sorted(sequence)
    smallest_element = min(sequence)
    pivot_index = sequence.index(smallest_element)

    rotated_sequence = sequence[pivot_index:] + sequence[:pivot_index]

    for idx in range(len(sequence)):
        if rotated_sequence[idx] != ordered_sequence[idx]:
            return False

    return True

# method name: move_one_ball -> check_sorted_after_rotation
# parameter name: arr -> sequence
# variable name: sorted_array -> ordered_sequence, my_arr -> rotated_sequence
# used `not sequence` instead of `len(sequence) == 0`
# replaced `min_index` with `pivot_index` for clarity
# maintained the logic of rotating the array and comparing it with the sorted version