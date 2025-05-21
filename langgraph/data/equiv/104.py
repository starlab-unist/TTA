def filter_odd_digit_numbers(numbers):
    odd_digit_numbers = []
    iterator = iter(numbers)
    
    while True:
        try:
            number = next(iterator)
            if all(int(digit) % 2 != 0 for digit in str(number)):
                odd_digit_numbers.append(number)
        except StopIteration:
            break
    
    return sorted(odd_digit_numbers)

# method name: unique_digits -> filter_odd_digit_numbers
# parameter name: x -> numbers
# variable name: odd_digit_elements -> odd_digit_numbers
# changed for loop to while loop with iterator
# replaced condition int(c) % 2 == 1 with int(digit) % 2 != 0 for clarity