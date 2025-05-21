def find_largest_prime_digit_sum(numbers):
    def check_prime(number):
        for divisor in range(2, int(number**0.5) + 1):
            if number % divisor == 0:
                return False
        return True

    largest_prime = 0
    index = 0
    while index < len(numbers):
        if numbers[index] > largest_prime and check_prime(numbers[index]):
            largest_prime = numbers[index]
        index += 1

    digit_sum = sum(int(char) for char in str(largest_prime))
    return digit_sum

# method name: skjkasdkd -> find_largest_prime_digit_sum
# parameter name: lst -> numbers
# inner function name: isPrime -> check_prime
# variable name: maxx -> largest_prime, i -> index
# replaced for loop with while loop for iteration
# used list comprehension for digit sum calculation with more descriptive variable names