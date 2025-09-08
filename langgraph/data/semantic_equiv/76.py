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
# replaced the condition with a more explicit form
# kept the logic and structure similar but changed identifiers and some syntax