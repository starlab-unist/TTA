def calculate_special_number(length):
    if length == 1:
        return 1
    multiplier = 18
    base = 10 ** (length - 2)
    return multiplier * base
# method name: starts_one_ends -> calculate_special_number
# parameter name: n -> length
# split the calculation into multiplier and base for clarity
# used separate lines for multiplication to enhance readability