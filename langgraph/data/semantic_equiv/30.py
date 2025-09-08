def extract_positive_numbers(input_list: list):
    positive_numbers = []
    index = 0

    while index < len(input_list):
        if input_list[index] > 0:
            positive_numbers.append(input_list[index])
        index += 1

    return positive_numbers
# method name: get_positive -> extract_positive_numbers
# parameter name: l -> input_list
# replaced list comprehension with a while loop and explicit list appending