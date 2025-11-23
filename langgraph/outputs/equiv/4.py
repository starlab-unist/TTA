from typing import List

def compute_mean_abs_deviation(data_points: List[float]) -> float:
    average = sum(data_points) / len(data_points)
    total_dev = 0.0
    for value in data_points:
        total_dev += abs(value - average)
    return total_dev / len(data_points)
# method name: mean_absolute_deviation -> compute_mean_abs_deviation
# parameter name: numbers -> data_points
# variable name: mean -> average, sum(...) -> total_dev
# replaced generator expression with explicit for loop
# changed variable names and structure