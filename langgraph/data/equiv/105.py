def arrange_by_number_name(numbers):
    number_names = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    }
    descending_numbers = sorted(numbers, key=lambda x: -x)
    named_numbers = []
    index = 0
    while index < len(descending_numbers):
        num = descending_numbers[index]
        if num in number_names:
            named_numbers.append(number_names[num])
        index += 1
    return named_numbers

# method name: by_length -> arrange_by_number_name
# parameter name: arr -> numbers
# variable name: dic -> number_names, sorted_arr -> descending_numbers, new_arr -> named_numbers
# replaced for loop with while loop
# used lambda function for sorting in reverse order
# added explicit check for num in number_names dictionary