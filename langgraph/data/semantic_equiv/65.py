def rotate_string(number, offset):
    num_str = str(number)
    length = len(num_str)
    
    if offset > length:
        return num_str[::-1]
    else:
        pivot = length - offset
        rotated = num_str[pivot:] + num_str[:pivot]
        return rotated

# method name: circular_shift -> rotate_string
# parameter name: x -> number, shift -> offset
# variable name: s -> num_str, len(s) -> length, pivot introduced for clarity
# replaced direct slicing with a calculated pivot point for rotation