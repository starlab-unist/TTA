def calculate_odd_digit_product(number):
    result = 1
    odd_digits_found = 0
    digit_iterator = iter(str(number))
    
    while True:
        try:
            current_digit = int(next(digit_iterator))
            if current_digit % 2 != 0:
                result *= current_digit
                odd_digits_found += 1
        except StopIteration:
            break
    
    return result if odd_digits_found > 0 else 0

# method name: digits -> calculate_odd_digit_product
# parameter name: n -> number
# variable name: product -> result, odd_count -> odd_digits_found
# replaced for loop with while loop and iterator
# used try-except block to handle the end of iteration
# converted the return condition to use direct comparison