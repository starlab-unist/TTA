def filter_and_check_palindrome(input_string, chars_to_remove):
    filtered_string = ''.join(character for character in input_string if character not in chars_to_remove)
    is_palindrome = filtered_string == filtered_string[::-1]
    return filtered_string, is_palindrome

# method name: reverse_delete -> filter_and_check_palindrome
# parameter name: s -> input_string, c -> chars_to_remove
# variable name: s -> filtered_string
# replaced list comprehension with a generator expression for clarity
# separated palindrome check into a separate variable for readability