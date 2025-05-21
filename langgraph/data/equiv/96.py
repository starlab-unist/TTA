def find_primes_below(limit):
    prime_numbers = []
    candidate = 2
    while candidate < limit:
        divisor = 2
        is_divisible = False
        while divisor < candidate:
            if candidate % divisor == 0:
                is_divisible = True
                break
            divisor += 1
        if not is_divisible:
            prime_numbers.append(candidate)
        candidate += 1
    return prime_numbers

# method name: count_up_to -> find_primes_below
# parameter name: n -> limit
# variable name: primes -> prime_numbers, i -> candidate, j -> divisor, is_prime -> is_divisible
# replaced for loop with while loop for both outer and inner loops
# changed the condition to check divisibility to set a flag `is_divisible`
# used `while` loop instead of `for` loop for iteration