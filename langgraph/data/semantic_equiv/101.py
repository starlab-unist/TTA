def convert_and_split_string(input_str):
    if not input_str:
        return []

    transformed_chars = []
    index = 0

    while index < len(input_str):
        current_char = input_str[index]
        if current_char == ',':
            transformed_chars.append(' ')
        else:
            transformed_chars.append(current_char)
        index += 1

    transformed_string = ''.join(transformed_chars)
    result_list = transformed_string.split()
    return result_list

# method name: words_string -> convert_and_split_string
# parameter name: s -> input_str
# for loop replaced with while loop
# variable name: s_list -> transformed_chars
# added index variable for while loop control
# joined list into string using ''.join() and then split into list