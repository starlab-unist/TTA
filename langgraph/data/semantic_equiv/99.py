def nearest_whole_number(input_value):
    from math import floor, ceil

    # Remove trailing zeros
    while input_value.endswith('0'):
        input_value = input_value[:-1]

    number = float(input_value)
    if input_value.endswith('.5'):
        result = ceil(number) if number > 0 else floor(number)
    else:
        result = int(round(number))

    return result

# method name: closest_integer -> nearest_whole_number
# parameter name: value -> input_value
# replaced the count check with endswith for simplicity
# used endswith('.5') directly instead of slicing
# simplified the else condition by removing unnecessary length check