def calculate_total_up_to(limit: int):
    total = 0
    for number in range(limit + 1):
        total += number
    return total

# method name: sum_to_n -> calculate_total_up_to
# parameter name: n -> limit
# replaced sum(range(...)) with a for loop to accumulate the total