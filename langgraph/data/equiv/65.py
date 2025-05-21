def rotate_string(number, offset):
    num_str = str(number)
    length = len(num_str)
    
    if offset >= length:
        return num_str[::-1]
    else:
        split_point = length - offset
        rotated_part = num_str[split_point:]
        remaining_part = num_str[:split_point]
        return rotated_part + remaining_part

# method name: circular_shift -> rotate_string
# parameter name: x -> number, shift -> offset
# variable name: s -> num_str, len(s) -> length
# introduced split_point for clarity in slicing
# used more descriptive variable names for sliced parts