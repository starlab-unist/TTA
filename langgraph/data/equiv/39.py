def find_nth_prime_fibonacci(index: int):
    import math

    def check_prime(number):
        if number < 2:
            return False
        limit = min(int(math.sqrt(number)) + 1, number - 1)
        divisor = 2
        while divisor < limit:
            if number % divisor == 0:
                return False
            divisor += 1
        return True

    fibonacci_sequence = [0, 1]
    while True:
        next_fib = fibonacci_sequence[-1] + fibonacci_sequence[-2]
        fibonacci_sequence.append(next_fib)
        if check_prime(next_fib):
            index -= 1
        if index == 0:
            return next_fib

# method name: prime_fib -> find_nth_prime_fibonacci
# parameter name: n -> index
# inner function name: is_prime -> check_prime
# replaced for loop with while loop in check_prime
# used append to add the next Fibonacci number directly to the list
# changed the return statement to return the last calculated Fibonacci number when index reaches 0