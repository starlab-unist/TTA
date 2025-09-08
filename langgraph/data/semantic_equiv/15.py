def generate_number_series(length: int) -> str:
    number_list = []
    index = 0
    while index <= length:
        number_list.append(str(index))
        index += 1
    return ' '.join(number_list)

# method name: string_sequence -> generate_number_series
# parameter name: n -> length
# list comprehension replaced with a while loop and append method
# variable name: words -> number_list
# range replaced with manual while loop increment