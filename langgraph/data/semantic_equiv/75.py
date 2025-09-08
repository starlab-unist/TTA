def check_product_of_three_primes(number):
    def prime_check(value):
        for divisor in range(2, value):
            if value % divisor == 0:
                return False
        return True

    prime_range = range(2, 101)
    for first_prime in prime_range:
        if not prime_check(first_prime):
            continue
        for second_prime in prime_range:
            if not prime_check(second_prime):
                continue
            for third_prime in prime_range:
                if not prime_check(third_prime):
                    continue
                if first_prime * second_prime * third_prime == number:
                    return True
    return False

# method name: is_multiply_prime -> check_product_of_three_primes
# parameter name: a -> number
# inner function name: is_prime -> prime_check
# changed variable names: i -> first_prime, j -> second_prime, k -> third_prime
# used a single range object for prime numbers to avoid repetition