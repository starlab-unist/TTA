def tally_positive_digit_sums(numbers):
    def compute_digit_sum(number):
        sign = 1
        if number < 0:
            number, sign = -number, -1
        digits = [int(digit) for digit in str(number)]
        digits[0] *= sign
        return sum(digits)

    positive_count = 0
    for num in numbers:
        if compute_digit_sum(num) > 0:
            positive_count += 1

    return positive_count

# method name: count_nums -> tally_positive_digit_sums
# parameter name: arr -> numbers
# inner function name: digits_sum -> compute_digit_sum
# replaced list comprehension and filter with a for loop and conditional increment
# changed the way the positive count is calculated and returned