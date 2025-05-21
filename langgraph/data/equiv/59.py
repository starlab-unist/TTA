def find_max_prime_divisor(number: int):
    def check_prime(candidate):
        if candidate < 2:
            return False
        divisor = 2
        while divisor * divisor <= candidate:
            if candidate % divisor == 0:
                return False
            divisor += 1
        return True

    max_prime = 1
    factor = 2
    while factor <= number:
        if number % factor == 0 and check_prime(factor):
            max_prime = factor
        factor += 1
    return max_prime

# method name: largest_prime_factor -> find_max_prime_divisor
# parameter name: n -> number
# inner function name: is_prime -> check_prime
# variable name: largest -> max_prime, j -> factor
# replaced for loop with while loop for factorization
# optimized prime checking by iterating only up to the square root of the candidate