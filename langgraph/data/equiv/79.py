def convert_decimal_to_binary(number):
    binary_representation = bin(number).replace("0b", "")
    return f"db{binary_representation}db"
# method name: decimal_to_binary -> convert_decimal_to_binary
# parameter name: decimal -> number
# replaced slicing [2:] with replace("0b", "")
# used f-string for formatting the return statement