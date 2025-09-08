def find_max_prime_divisor(number: int):
    def check_primality(candidate):
        if candidate < 2:
            return False
        for divisor in range(2, candidate):
            if candidate % divisor == 0:
                return False
        return True

    max_prime = 1
    potential_divisor = 2
    while potential_divisor <= number:
        if number % potential_divisor == 0 and check_primality(potential_divisor):
            max_prime = max(max_prime, potential_divisor)
        potential_divisor += 1

    return max_prime

# method name: largest_prime_factor -> find_max_prime_divisor
# parameter name: n -> number
# variable name: largest -> max_prime, j -> potential_divisor
# changed for loop to while loop
# renamed inner function: is_prime -> check_primality
# adjusted the range in check_primality to avoid unnecessary checks