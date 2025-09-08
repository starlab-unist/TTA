def count_sevens_in_multiples(limit: int):
    multiples = []
    index = 0
    while index < limit:
        if index % 11 == 0 or index % 13 == 0:
            multiples.append(index)
        index += 1
    
    concatenated_string = ''.join(str(num) for num in multiples)
    seven_count = 0
    position = 0
    while position < len(concatenated_string):
        if concatenated_string[position] == '7':
            seven_count += 1
        position += 1
    
    return seven_count

# method name: fizz_buzz -> count_sevens_in_multiples
# parameter name: n -> limit
# loop structure: for -> while
# list comprehension used for appending multiples
# string concatenation using generator expression
# second loop structure: for -> while
# variable names changed: ns -> multiples, s -> concatenated_string, ans -> seven_count, c -> _