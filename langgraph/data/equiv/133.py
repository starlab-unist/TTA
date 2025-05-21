def calculate_total_squared_ceilings(numbers):
    import math
    total = 0
    iterator = iter(numbers)
    while True:
        try:
            number = next(iterator)
            total += math.ceil(number) ** 2
        except StopIteration:
            break
    return total

# method name: sum_squares -> calculate_total_squared_ceilings
# parameter name: lst -> numbers
# variable name: squared -> total
# replaced for loop with while loop using iterator and try-except block