def increment_elements(input_list: list):
    result = []
    index = 0
    while index < len(input_list):
        result.append(input_list[index] + 1)
        index += 1
    return result

# method name: incr_list -> increment_elements
# parameter name: l -> input_list
# replaced list comprehension with a while loop and explicit list appending