from typing import List

def arrange_numerals(number_string: str) -> str:
    numeral_to_digit = {
        'zero': 0,
        'one': 1,
        'two': 2,
        'three': 3,
        'four': 4,
        'five': 5,
        'six': 6,
        'seven': 7,
        'eight': 8,
        'nine': 9
    }
    
    # Split the input string and filter out any empty strings
    numeral_list = [numeral for numeral in number_string.split(' ') if numeral]
    
    # Sort the list based on the mapped digit values
    sorted_numerals = sorted(numeral_list, key=lambda n: numeral_to_digit[n])
    
    # Join the sorted numerals back into a single string
    return ' '.join(sorted_numerals)

# method name: sort_numbers -> arrange_numerals
# parameter name: numbers -> number_string
# variable name: value_map -> numeral_to_digit, words -> numeral_list
# used list comprehension for filtering and sorting separately for clarity
# joined the sorted list directly in the return statement