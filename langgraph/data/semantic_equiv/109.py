def check_sorted_rotation(array):
    if not array:
        return True

    ordered_array = sorted(array)
    smallest_element = min(array)
    pivot_index = array.index(smallest_element)

    rotated_array = array[pivot_index:] + array[:pivot_index]

    for idx in range(len(array)):
        if rotated_array[idx] != ordered_array[idx]:
            return False

    return True

# method name: move_one_ball -> check_sorted_rotation
# parameter name: arr -> array
# variable name: sorted_array -> ordered_array, my_arr -> rotated_array
# used 'not array' instead of 'len(arr)==0'
# changed the way the rotated array is constructed using slicing
# kept the logic of comparing the rotated array with the sorted array