def transform_string(input_string):
    modified = False
    position = 0
    result_chars = list(input_string)
    for char in input_string:
        if char.isalpha():
            result_chars[position] = char.swapcase()
            modified = True
        position += 1
    transformed_string = ''.join(result_chars)
    if not modified:
        return transformed_string[::-1]
    return transformed_string

# method name: solve -> transform_string
# parameter name: s -> input_string
# variable name: flg -> modified, idx -> position, new_str -> result_chars
# replaced the manual string concatenation with ''.join()
# used slicing for reversing the string instead of a loop
# changed the condition check for modified flag