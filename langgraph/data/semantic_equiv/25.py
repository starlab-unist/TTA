from typing import List
import math

def decompose_number(number: int) -> List[int]:
    factors = []
    divisor = 2
    while divisor <= math.isqrt(number):
        if number % divisor == 0:
            factors.append(divisor)
            number //= divisor
        else:
            divisor += 1

    if number > 1:
        factors.append(number)
    return factors

# method name: factorize -> decompose_number
# parameter name: n -> number
# variable name: fact -> factors, i -> divisor
# replaced math.sqrt(n) + 1 with math.isqrt(number) for integer square root
# kept the logic and structure similar but changed identifiers and added a comment about the integer square root