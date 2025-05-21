import math

def calculate_max_load(matrix, limit):
    total_load = 0
    for row in matrix:
        total_load += math.ceil(sum(row) / limit)
    return total_load

# method name: max_fill -> calculate_max_load
# parameter name: grid -> matrix, capacity -> limit
# replaced list comprehension with a for loop to iterate over rows
# used a running total (total_load) instead of summing a list comprehension directly