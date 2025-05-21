def sort_numbers_by_digit_sum(numbers):
    def calculate_weight(number):
        sign = -1 if number < 0 else 1
        absolute_value = abs(number)
        digits = [int(digit) for digit in str(absolute_value)]
        digits[0] *= sign
        return sum(digits)
    
    return sorted(numbers, key=calculate_weight)

# method name: order_by_points -> sort_numbers_by_digit_sum
# parameter name: nums -> numbers
# inner function name: digits_sum -> calculate_weight
# changed variable names: n -> number, neg -> sign, n -> digits
# used abs() instead of manually multiplying by -1
# simplified the condition for sign assignment