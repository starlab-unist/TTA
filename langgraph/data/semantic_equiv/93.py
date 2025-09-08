def transform_message(input_text):
    vowel_set = "aeiouAEIOU"
    vowel_mapping = {char: chr(ord(char) + 2) for char in vowel_set}
    modified_text = input_text.swapcase()
    result = []

    for character in modified_text:
        if character in vowel_mapping:
            result.append(vowel_mapping[character])
        else:
            result.append(character)

    return ''.join(result)
# method name: encode -> transform_message
# parameter name: message -> input_text
# variable name: vowels -> vowel_set, vowels_replace -> vowel_mapping
# replaced list comprehension with a for loop for character processing
# used a list called result to collect characters before joining them