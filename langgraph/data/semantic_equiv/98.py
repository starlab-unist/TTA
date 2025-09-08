def tally_even_indexed_vowels(input_string):
    vowel_count = 0
    index = 0
    while index < len(input_string):
        if index % 2 == 0 and input_string[index] in "AEIOU":
            vowel_count += 1
        index += 1
    return vowel_count

# method name: count_upper -> tally_even_indexed_vowels
# parameter name: s -> input_string
# variable name: count -> vowel_count, i -> index
# replaced for loop with while loop and added condition for even index