def calculate_modified_fibonacci(index: int):
    if index == 0:
        return 0
    elif index == 1:
        return 0
    elif index == 2:
        return 1
    else:
        return (calculate_modified_fibonacci(index - 1) +
                calculate_modified_fibonacci(index - 2) +
                calculate_modified_fibonacci(index - 3))

# method name: fibfib -> calculate_modified_fibonacci
# replaced if n == x with if index == x for consistency
# added else: for clarity before the recursive return statement
# used parentheses for better readability of the return statement