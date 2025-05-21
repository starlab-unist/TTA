def find_greatest_divisor(number: int) -> int:
    divisor = number - 1
    while divisor > 0:
        if number % divisor == 0:
            return divisor
        divisor -= 1

# method name: largest_divisor -> find_greatest_divisor
# parameter name: n -> number
# changed for loop to while loop
# replaced reversed(range(n)) with explicit decrementing variable