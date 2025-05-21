def select_number(a, b):
    if a > b:
        return -1
    elif b % 2 == 0:
        return b
    elif a == b:
        return -1
    else:
        return b - 1

# method name: choose_num -> select_number
# parameter names: x -> a, y -> b
# replaced if statements with if-elif-else for clarity
# maintained the same logic and return values