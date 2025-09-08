def strip_vowels(input_string):
    vowels = {"a", "e", "i", "o", "u"}
    result = []

    for character in input_string:
        if character.lower() not in vowels:
            result.append(character)

    return ''.join(result)
# method name: remove_vowels -> strip_vowels
# parameter name: text -> input_string
# changed list comprehension to for loop with if condition
# used set for vowels for faster lookup
# replaced "".join([...]) with appending to a list and then joining it