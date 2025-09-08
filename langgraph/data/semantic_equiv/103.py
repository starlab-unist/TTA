def calculate_binary_average(start, end):
    if end < start:
        return -1
    total_sum = 0
    current = start
    while current <= end:
        total_sum += current
        current += 1
    average = round(total_sum / (end - start + 1))
    return bin(average)

# method name: rounded_avg -> calculate_binary_average
# parameter name: n -> start, m -> end
# variable name: summation -> total_sum, i -> current
# replaced for loop with while loop
# kept the logic for calculating the average and converting it to binary