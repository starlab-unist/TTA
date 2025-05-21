def calculate_minimum_subarray_sum(numbers):
    current_sum = 0
    highest_negative_sum = 0
    for value in numbers:
        current_sum += -value
        if current_sum < 0:
            current_sum = 0
        highest_negative_sum = max(current_sum, highest_negative_sum)
    
    if highest_negative_sum == 0:
        highest_negative_sum = max(-val for val in numbers)
    
    minimum_sum = -highest_negative_sum
    return minimum_sum

# method name: minSubArraySum -> calculate_minimum_subarray_sum
# parameter name: nums -> numbers
# variable name: max_sum -> highest_negative_sum, s -> current_sum
# used a for loop with a more descriptive variable name 'value'
# maintained the same logic and structure but with clearer naming