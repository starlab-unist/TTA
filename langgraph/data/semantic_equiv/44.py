def convert_number_to_base(number: int, target_base: int):
    result = ""
    while number > 0:
        remainder = number % target_base
        result = str(remainder) + result
        number = number // target_base
    return result

# method name: change_base -> convert_number_to_base
# parameter name: x -> number, base -> target_base
# variable name: ret -> result, introduced remainder for clarity
# replaced x //= base with number = number // target_base for clarity