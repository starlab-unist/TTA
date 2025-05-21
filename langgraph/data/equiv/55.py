def calculate_fibonacci(sequence_index: int):
    if sequence_index == 0:
        return 0
    elif sequence_index == 1:
        return 1

    previous, current = 0, 1
    index = 2
    while index <= sequence_index:
        previous, current = current, previous + current
        index += 1

    return current

# method name: fib -> calculate_fibonacci
# parameter name: n -> sequence_index
# replaced recursion with an iterative approach using a while loop
# introduced variables: previous, current, index to manage the iteration