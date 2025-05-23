import math

def evaluate_polynomial(coefficients: list, value: float):
    """
    Calculates the value of a polynomial with given coefficients at a specific point.
    The polynomial is defined as: coefficients[0] + coefficients[1] * value + coefficients[2] * value^2 + ... + coefficients[n] * value^n
    """
    result = 0.0
    for index, coefficient in enumerate(coefficients):
        result += coefficient * math.pow(value, index)
    return result

def locate_root(polynomial_coeffs: list):
    lower_bound, upper_bound = -1.0, 1.0
    while evaluate_polynomial(polynomial_coeffs, lower_bound) * evaluate_polynomial(polynomial_coeffs, upper_bound) > 0:
        lower_bound *= 2.0
        upper_bound *= 2.0
    
    while upper_bound - lower_bound > 1e-10:
        midpoint = (lower_bound + upper_bound) / 2.0
        if evaluate_polynomial(polynomial_coeffs, midpoint) * evaluate_polynomial(polynomial_coeffs, lower_bound) > 0:
            lower_bound = midpoint
        else:
            upper_bound = midpoint
    
    return lower_bound

# method name: poly -> evaluate_polynomial
# method name: find_zero -> locate_root
# parameter name: xs -> coefficients, x -> value
# parameter name: xs -> polynomial_coeffs
# variable name: begin -> lower_bound, end -> upper_bound
# variable name: center -> midpoint
# replaced list comprehension with for loop in evaluate_polynomial
# kept the same logic and structure for locating the root