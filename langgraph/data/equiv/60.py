def calculate_total_up_to(number: int):
    total_sum = 0
    current = 0
    
    while current <= number:
        total_sum += current
        current += 1
    
    return total_sum

# method name: sum_to_n -> calculate_total_up_to
# parameter name: n -> number
# replaced sum(range(n + 1)) with a while loop to manually accumulate the sum
# introduced two new variables: total_sum and current