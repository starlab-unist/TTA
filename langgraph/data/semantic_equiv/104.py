def filter_odd_digit_numbers(numbers):
    result = []
    index = 0
    while index < len(numbers):
        number_str = str(numbers[index])
        if all(int(digit) % 2 != 0 for digit in number_str):
            result.append(numbers[index])
        index += 1
    return sorted(result)

# method name: unique_digits -> filter_odd_digit_numbers
# parameter name: x -> numbers
# variable name: odd_digit_elements -> result
# replaced for loop with while loop
# changed condition from int(c) % 2 == 1 to int(digit) % 2 != 0 for clarity
# incremented index manually in the while loop