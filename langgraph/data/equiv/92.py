def check_sum_of_two_equals_third(a, b, c):
    if all(isinstance(i, int) for i in (a, b, c)):
        if a + b == c or a + c == b or b + c == a:
            return True
        return False
    return False

# method name: any_int -> check_sum_of_two_equals_third
# parameter names: x -> a, y -> b, z -> c
# replaced individual isinstance checks with a generator expression inside all()
# maintained the same logic and output structure