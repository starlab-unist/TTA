def check_prime(number):
    if number < 2:
        return False
    divisor = 2
    while divisor < number - 1:
        if number % divisor == 0:
            return False
        divisor += 1
    return True

# method name: is_prime -> check_prime
# parameter name: n -> number
# replaced for loop with while loop
# introduced a new variable 'divisor' to iterate through potential divisors