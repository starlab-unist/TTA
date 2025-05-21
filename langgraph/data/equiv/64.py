FIX = """
Add more test cases.
"""

def tally_vowels(input_string):
    vowel_set = "aeiouAEIOU"
    vowel_counter = 0

    for character in input_string:
        if character in vowel_set:
            vowel_counter += 1

    if input_string.endswith(('y', 'Y')):
        vowel_counter += 1

    return vowel_counter

# method name: vowels_count -> tally_vowels
# parameter name: s -> input_string
# variable name: vowels -> vowel_set, n_vowels -> vowel_counter
# replaced sum with for loop for counting vowels
# used str.endswith() method for checking the last character