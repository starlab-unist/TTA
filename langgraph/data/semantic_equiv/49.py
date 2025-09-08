def calculate_modular_exponentiation(number: int, prime: int) -> int:
    result = 1
    index = 0
    while index < number:
        result = (2 * result) % prime
        index += 1
    return result

# method name: modp -> calculate_modular_exponentiation
# parameter name: n -> number, p -> prime
# variable name: ret -> result, i -> index
# changed for loop to while loop