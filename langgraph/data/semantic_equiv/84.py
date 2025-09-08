def calculate_binary_sum(number):
    digit_sum = sum(int(digit) for digit in str(number))
    binary_representation = bin(digit_sum)[2:]
    return binary_representation

# method name: solve -> calculate_binary_sum
# parameter name: N -> number
# introduced intermediate variable digit_sum for clarity
# used bin() and slicing to get binary representation without '0b' prefix