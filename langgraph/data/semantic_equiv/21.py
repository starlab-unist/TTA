from typing import List


def normalize_values(values: List[float]) -> List[float]:
    smallest = min(values)
    largest = max(values)
    range_value = largest - smallest
    normalized = [((value - smallest) / range_value) for value in values]
    return normalized

# method name: rescale_to_unit -> normalize_values
# parameter name: numbers -> values
# variable name: min_number -> smallest, max_number -> largest
# introduced new variable: range_value to store the difference between largest and smallest
# kept list comprehension for normalization but used new variable names