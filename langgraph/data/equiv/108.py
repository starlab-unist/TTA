def tally_positive_digit_sums(numbers):
    def compute_digit_sum(number):
        sign = -1 if number < 0 else 1
        absolute_value = abs(number)
        digit_list = [int(digit) for digit in str(absolute_value)]
        digit_list[0] *= sign
        return sum(digit_list)

    positive_sums_count = 0
    for num in numbers:
        if compute_digit_sum(num) > 0:
            positive_sums_count += 1

    return positive_sums_count

# method name: count_nums -> tally_positive_digit_sums
# parameter name: arr -> numbers
# inner function name: digits_sum -> compute_digit_sum
# replaced list comprehension and filter with a for loop and conditional increment
# changed the way the negative sign is handled and applied it directly to the first digit
# replaced lambda with a direct comparison in the for loop