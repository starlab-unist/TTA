def generate_primes_below(limit):
    prime_numbers = []
    candidate = 2
    while candidate < limit:
        divisor = 2
        remains_prime = True
        while divisor < candidate:
            if candidate % divisor == 0:
                remains_prime = False
                break
            divisor += 1
        if remains_prime:
            prime_numbers.append(candidate)
        candidate += 1
    return prime_numbers

# method name: count_up_to -> generate_primes_below
# parameter name: n -> limit
# variable name: primes -> prime_numbers, i -> candidate, is_prime -> remains_prime, j -> divisor
# changed for loop to while loop for both outer and inner loops
# incremented divisor and candidate manually within the while loops