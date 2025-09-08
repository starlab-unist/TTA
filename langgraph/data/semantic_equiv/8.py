from typing import List, Tuple


def calculate_aggregates(values: List[int]) -> Tuple[int, int]:
    total_sum = 0
    cumulative_product = 1

    index = 0
    while index < len(values):
        total_sum += values[index]
        cumulative_product *= values[index]
        index += 1

    return total_sum, cumulative_product

# method name: sum_product -> calculate_aggregates
# parameter name: numbers -> values
# variable name: sum_value -> total_sum, prod_value -> cumulative_product
# replaced for loop with while loop