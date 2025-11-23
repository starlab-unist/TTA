import math

def extract_decimal_fraction(value: float) -> float:
    return value - math.floor(value)

# method name: truncate_number -> extract_decimal_fraction
# parameter name: number -> value
# implementation changed from modulo operation to floor subtraction
# added math import for floor function