def shift_encode(input_string: str):
    """
    Encodes the input string by shifting each character forward by 5 positions in the alphabet.
    """
    encoded_chars = []
    for character in input_string:
        shifted_char = chr(((ord(character) + 5 - ord("a")) % 26) + ord("a"))
        encoded_chars.append(shifted_char)
    return ''.join(encoded_chars)


def shift_decode(encoded_string: str):
    decoded_chars = []
    index = 0
    while index < len(encoded_string):
        original_char = chr(((ord(encoded_string[index]) - 5 - ord("a")) % 26) + ord("a"))
        decoded_chars.append(original_char)
        index += 1
    return ''.join(decoded_chars)

# method name: encode_shift -> shift_encode
# method name: decode_shift -> shift_decode
# parameter name: s -> input_string, s -> encoded_string
# replaced list comprehension with for loop in shift_encode
# replaced list comprehension with while loop in shift_decode
# used append method to add characters to the list instead of using join directly on the comprehension