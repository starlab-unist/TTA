def calculate_modular_exponentiation(base_count: int, modulus: int):
    result = 1
    index = 0
    while index < base_count:
        result = (2 * result) % modulus
        index += 1
    return result

# method name: modp -> calculate_modular_exponentiation
# parameter name: n -> base_count, p -> modulus
# variable name: ret -> result, i -> index
# changed for loop to while loop