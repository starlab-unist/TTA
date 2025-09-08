def calculate_special_number(length):
    if length == 1:
        return 1
    return 18 * (10 ** (length - 2))
# method name: starts_one_ends -> calculate_special_number
# parameter name: n -> length
# no other changes in logic or structure, just naming conventions