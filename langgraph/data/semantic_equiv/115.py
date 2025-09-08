import math

def calculate_max_capacity_usage(matrix, limit):
    total_usage = 0
    for row in matrix:
        total_usage += math.ceil(sum(row) / limit)
    return total_usage

# method name: max_fill -> calculate_max_capacity_usage
# parameter name: grid -> matrix, capacity -> limit
# changed list comprehension to a for loop for summation
# used a separate variable total_usage to accumulate the result