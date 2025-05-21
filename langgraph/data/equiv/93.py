def transform_message(input_text):
    vowel_set = "aeiouAEIOU"
    vowel_mapping = {char: chr(ord(char) + 2) for char in vowel_set}
    modified_text = input_text.swapcase()
    result = ''.join(vowel_mapping.get(char, char) for char in modified_text)
    return result

# method name: encode -> transform_message
# parameter name: message -> input_text
# variable name: vowels -> vowel_set, vowels_replace -> vowel_mapping
# replaced list comprehension with dictionary comprehension for vowel mapping
# used str.join with generator expression for constructing the result string
# replaced ternary operator with dict.get method for cleaner lookup