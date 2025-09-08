def check_sum_of_two(a, b, c):
    if all(isinstance(i, int) for i in (a, b, c)):
        if a + b == c or a + c == b or b + c == a:
            return True
        return False
    return False

# method name: any_int -> check_sum_of_two
# parameter names: x -> a, y -> b, z -> c
# replaced individual isinstance checks with a single all() function call
# maintained the logic for checking sum conditions