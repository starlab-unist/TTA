def map_numbers_to_words(numbers):
    number_to_word_map = {
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
    descending_sorted_numbers = sorted(numbers, reverse=True)
    result = []
    index = 0
    while index < len(descending_sorted_numbers):
        num = descending_sorted_numbers[index]
        if num in number_to_word_map:
            result.append(number_to_word_map[num])
        index += 1
    return result

# method name: by_length -> map_numbers_to_words
# parameter name: arr -> numbers
# variable name: dic -> number_to_word_map, sorted_arr -> descending_sorted_numbers, new_arr -> result
# replaced for loop with while loop
# used if condition instead of try-except for checking dictionary key existence