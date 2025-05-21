def nearest_whole_number(input_value):
    from math import floor, ceil

    if '.' in input_value:
        # strip trailing zeros
        while input_value.endswith('0'):
            input_value = input_value[:-1]

    number = float(input_value)
    if input_value.endswith('.5'):
        result = ceil(number) if number > 0 else floor(number)
    elif input_value:
        result = int(round(number))
    else:
        result = 0

    return result

# method name: closest_integer -> nearest_whole_number
# parameter name: value -> input_value
# replaced value.count('.') == 1 with '.' in input_value for checking decimal point
# replaced while loop condition (value[-1] == '0') with input_value.endswith('0')
# used input_value.endswith('.5') instead of value[-2:] == '.5'
# simplified the elif condition to just check if input_value is not empty
# used int(round(number)) directly in the elif block