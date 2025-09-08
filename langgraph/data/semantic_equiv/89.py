def shift_cipher(input_string):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    result = ''
    index = 0
    while index < len(input_string):
        character = input_string[index]
        if character in alphabet:
            new_position = (alphabet.index(character) + 4) % 26
            result += alphabet[new_position]
        else:
            result += character
        index += 1
    return result

# method name: encrypt -> shift_cipher
# parameter name: s -> input_string
# variable name: d -> alphabet, out -> result, c -> character
# changed for loop to while loop
# simplified the shift calculation (2*2 -> 4)
# used index variable for while loop iteration