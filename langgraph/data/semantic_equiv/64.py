FIX = """
Add more test cases.
"""

def tally_vowels(input_string):
    vowel_set = set("aeiouAEIOU")
    vowel_tally = 0

    for character in input_string:
        if character in vowel_set:
            vowel_tally += 1

    if input_string.endswith(('y', 'Y')):
        vowel_tally += 1

    return vowel_tally

# method name: vowels_count -> tally_vowels
# parameter name: s -> input_string
# variable name: vowels -> vowel_set, n_vowels -> vowel_tally
# replaced the sum with a for loop and if condition
# used str.endswith() for checking the last character