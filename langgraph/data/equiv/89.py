def cipher_text(input_string):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    result = []
    for character in input_string:
        if character in alphabet:
            new_index = (alphabet.index(character) + 4) % 26
            result.append(alphabet[new_index])
        else:
            result.append(character)
    return ''.join(result)

# method name: encrypt -> cipher_text
# parameter name: s -> input_string
# variable name: d -> alphabet, out -> result
# replaced string concatenation with list append and ''.join() for efficiency
# simplified the shift calculation (2*2 -> 4) directly in the code