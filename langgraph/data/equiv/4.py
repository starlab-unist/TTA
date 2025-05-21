from typing import List

def calculate_mean_abs_dev(values: List[float]) -> float:
    average = sum(values) / len(values)
    deviation_sum = sum(abs(value - average) for value in values)
    return deviation_sum / len(values)

# method name: mean_absolute_deviation -> calculate_mean_abs_dev
# parameter name: numbers -> values
# variable name: mean -> average, counts -> deviation_sum
# changed the order of operations slightly by storing the sum of deviations in a variable