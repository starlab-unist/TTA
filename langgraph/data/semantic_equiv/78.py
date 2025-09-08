def count_prime_hex_digits(hex_string):
    prime_hex_digits = {'2', '3', '5', '7', 'B', 'D'}
    count = 0
    index = 0
    while index < len(hex_string):
        if hex_string[index] in prime_hex_digits:
            count += 1
        index += 1
    return count

# method name: hex_key -> count_prime_hex_digits
# parameter name: num -> hex_string
# variable name: primes -> prime_hex_digits, total -> count
# replaced for loop with while loop
# used a set for prime_hex_digits for potentially faster membership testing