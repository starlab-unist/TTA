from typing import List

def calculate_mean_abs_dev(values: List[float]) -> float:
    average = sum(values) / len(values)
    deviations = [abs(value - average) for value in values]
    return sum(deviations) / len(values)

# method name: mean_absolute_deviation -> calculate_mean_abs_dev
# parameter name: numbers -> values
# variable name: mean -> average, counts -> deviations
# replaced generator expression with list comprehension for clarity