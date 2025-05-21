def generate_number_series(length: int) -> str:
    number_list = []
    index = 0

    while index <= length:
        number_list.append(str(index))
        index += 1

    series = ' '.join(number_list)
    return series
# method name: string_sequence -> generate_number_series
# parameter name: n -> length
# replaced list comprehension with while loop to append numbers to the list
# introduced a new variable 'number_list' to store the numbers as strings
# used a 'while' loop instead of a list comprehension
# explicitly joined the list elements into a string with spaces