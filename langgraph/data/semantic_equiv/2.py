def extract_decimal_part(value: float) -> float:
    decimal_part = value - int(value)
    return decimal_part

# method name: truncate_number -> extract_decimal_part
# parameter name: number -> value
# replaced modulo operation with subtraction of integer part
# added a variable to store the result for clarity