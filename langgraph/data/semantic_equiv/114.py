def find_minimum_subarray_sum(values):
    current_min = 0
    total = 0
    iterator = iter(values)
    
    for value in iterator:
        total -= value
        if total > 0:
            total = 0
        current_min = min(total, current_min)
    
    if current_min == 0:
        current_min = min(values)
    
    result = -current_min
    return result

# method name: minSubArraySum -> find_minimum_subarray_sum
# parameter name: nums -> values
# variable name: max_sum -> current_min, s -> total
# replaced for loop with explicit iterator
# changed the condition from s < 0 to total > 0 for equivalent logic
# used min function directly on values instead of generator expression for max negative
# renamed final result variable to result for clarity