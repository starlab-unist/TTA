def count_sevens_in_special_numbers(limit: int):
    special_numbers = []
    index = 0
    while index < limit:
        if index % 11 == 0 or index % 13 == 0:
            special_numbers.append(index)
        index += 1

    concatenated_string = ''.join(str(number) for number in special_numbers)
    seven_count = 0
    position = 0
    while position < len(concatenated_string):
        if concatenated_string[position] == '7':
            seven_count += 1
        position += 1

    return seven_count

# method name: fizz_buzz -> count_sevens_in_special_numbers
# parameter name: n -> limit
# variable name: ns -> special_numbers, i -> index, s -> concatenated_string, ans -> seven_count, c -> _
# replaced for loop with while loop for iteration
# used list comprehension for string conversion within join
# replaced for loop with while loop for counting '7's