def convert_to_base(number: int, target_base: int) -> str:
    result = ""
    while number > 0:
        remainder = number % target_base
        result = str(remainder) + result
        number = number // target_base
    return result

# method name: change_base -> convert_to_base
# parameter name: x -> number, base -> target_base
# variable name: ret -> result
# added type hint for return value
# extracted remainder calculation for clarity