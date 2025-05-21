def strip_vowels(input_string):
    vowels = set("aeiouAEIOU")
    result = []
    index = 0

    while index < len(input_string):
        char = input_string[index]
        if char not in vowels:
            result.append(char)
        index += 1

    return ''.join(result)

# method name: remove_vowels -> strip_vowels
# parameter name: text -> input_string
# replaced list comprehension with while loop and list append
# used a set for vowels to improve lookup efficiency
# manually built the result string using a list and join