def check_prime_length(sequence):
    length = len(sequence)
    if length < 2:
        return False
    divisor = 2
    while divisor < length:
        if length % divisor == 0:
            return False
        divisor += 1
    return True

# method name: prime_length -> check_prime_length
# parameter name: string -> sequence
# variable name: l -> length, i -> divisor
# replaced for loop with while loop
# changed condition to length < 2 for clarity