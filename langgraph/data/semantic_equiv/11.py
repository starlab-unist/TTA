from typing import List

def binary_string_difference(str1: str, str2: str) -> str:
    def bit_diff(c1, c2):
        return '0' if c1 == c2 else '1'

    result = []
    index = 0
    while index < len(str1):
        result.append(bit_diff(str1[index], str2[index]))
        index += 1

    return ''.join(result)

# method name: string_xor -> binary_string_difference
# parameter names: a -> str1, b -> str2
# inner function name: xor -> bit_diff
# replaced list comprehension with while loop and explicit list appending