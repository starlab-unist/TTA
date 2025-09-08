def invert_character_case(input_text: str) -> str:
    result = ''
    for char in input_text:
        if char.islower():
            result += char.upper()
        elif char.isupper():
            result += char.lower()
        else:
            result += char
    return result
# method name: flip_case -> invert_character_case
# parameter name: string -> input_text
# replaced swapcase() with manual character case inversion using a loop and conditionals