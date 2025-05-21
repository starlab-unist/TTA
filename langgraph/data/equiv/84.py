def convert_to_binary_string(number):
    digit_sum = sum(int(digit) for digit in str(number))
    binary_representation = bin(digit_sum)[2:]
    return binary_representation

# method name: solve -> convert_to_binary_string
# parameter name: N -> number
# introduced variable: digit_sum to hold the sum of digits
# introduced variable: binary_representation to hold the binary string result
# kept the logic of converting the sum of digits to a binary string without '0b' prefix