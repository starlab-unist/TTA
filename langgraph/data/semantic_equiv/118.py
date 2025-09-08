def find_inner_vowel(sequence):
    if len(sequence) < 3:
        return ""

    vowel_set = set("aeiouAEIOU")
    index = len(sequence) - 2

    while index > 0:
        if sequence[index] in vowel_set:
            if sequence[index + 1] not in vowel_set and sequence[index - 1] not in vowel_set:
                return sequence[index]
        index -= 1

    return ""
# method name: get_closest_vowel -> find_inner_vowel
# parameter name: word -> sequence
# variable name: vowels -> vowel_set
# replaced for loop with while loop
# changed the condition check for vowels surrounding the current character