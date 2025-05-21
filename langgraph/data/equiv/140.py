def adjust_whitespace(input_string):
    result = ""
    index = 0
    begin, finish = 0, 0
    while index < len(input_string):
        if input_string[index] == " ":
            finish += 1
        else:
            space_count = finish - begin
            if space_count > 2:
                result += "-" + input_string[index]
            elif space_count > 0:
                result += "_" * space_count + input_string[index]
            else:
                result += input_string[index]
            begin, finish = index + 1, index + 1
        index += 1
    final_space_count = finish - begin
    if final_space_count > 2:
        result += "-"
    elif final_space_count > 0:
        result += "_"
    return result

# method name: fix_spaces -> adjust_whitespace
# parameter name: text -> input_string
# variable name: new_text -> result, i -> index, start -> begin, end -> finish
# replaced inline conditions with a separate variable for space count (space_count)
# maintained the same logic and output structure