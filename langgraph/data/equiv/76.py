def check_power_relation(base, exponent):
    if exponent == 1:
        return base == 1
    
    current_value = 1
    while current_value < base:
        current_value *= exponent
    
    return current_value == base

# method name: is_simple_power -> check_power_relation
# parameter name: x -> base, n -> exponent
# variable name: power -> current_value
# replaced the inline return with a more explicit return statement