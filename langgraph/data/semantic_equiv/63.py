def calculate_modified_fibonacci(index: int):
    if index == 0:
        return 0
    elif index == 1:
        return 0
    elif index == 2:
        return 1
    else:
        return calculate_modified_fibonacci(index - 1) + calculate_modified_fibonacci(index - 2) + calculate_modified_fibonacci(index - 3)

# method name: fibfib -> calculate_modified_fibonacci
# parameter name: n -> index
# added elif for clarity in condition checks
# no other changes in logic or functionality