def calculate_fibonacci(index: int):
    if index == 0:
        return 0
    elif index == 1:
        return 1
    else:
        previous, current = 0, 1
        for _ in range(2, index + 1):
            previous, current = current, previous + current
        return current

# method name: fib -> calculate_fibonacci
# parameter name: n -> index
# replaced recursion with an iterative approach using a for loop
# introduced variables: previous, current to store Fibonacci numbers
# used tuple unpacking to update previous and current values