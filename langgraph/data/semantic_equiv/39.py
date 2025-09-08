def find_nth_prime_fibonacci(index: int):
    import math

    def check_for_primality(number):
        if number < 2:
            return False
        for divisor in range(2, min(int(math.sqrt(number)) + 1, number - 1)):
            if number % divisor == 0:
                return False
        return True

    fibonacci_sequence = [0, 1]
    while True:
        next_fibonacci = fibonacci_sequence[-1] + fibonacci_sequence[-2]
        fibonacci_sequence.append(next_fibonacci)
        if check_for_primality(next_fibonacci):
            index -= 1
        if index == 0:
            return next_fibonacci

# method name: prime_fib -> find_nth_prime_fibonacci
# parameter name: n -> index
# function name: is_prime -> check_for_primality
# list name: f -> fibonacci_sequence
# variable name: p -> number, k -> divisor
# replaced f[-1] + f[-2] calculation with a new variable next_fibonacci
# kept the core logic of generating Fibonacci numbers and checking for primality