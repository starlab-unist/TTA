def check_product_of_three_primes(number):
    def prime_check(value):
        for divisor in range(2, value):
            if value % divisor == 0:
                return False
        return True

    prime_range = range(2, 101)
    for first in prime_range:
        if not prime_check(first):
            continue
        for second in prime_range:
            if not prime_check(second):
                continue
            for third in prime_range:
                if not prime_check(third):
                    continue
                if first * second * third == number:
                    return True
    return False

# method name: is_multiply_prime -> check_product_of_three_primes
# parameter name: a -> number
# inner function name: is_prime -> prime_check
# variable name: i -> first, j -> second, k -> third
# changed the range variable name to prime_range for clarity
# kept the nested loop structure but added comments for clarity