def select_number(a, b):
    if a > b:
        result = -1
    elif b % 2 == 0:
        result = b
    elif a == b:
        result = -1
    else:
        result = b - 1

    return result
# method name: choose_num -> select_number
# parameter names: x -> a, y -> b
# replaced if-else statements with a single if-elif-else block
# introduced a result variable to store the final value to be returned