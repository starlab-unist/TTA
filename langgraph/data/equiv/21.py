from typing import List


def normalize_values(values: List[float]) -> List[float]:
    smallest_value = min(values)
    largest_value = max(values)
    range_value = largest_value - smallest_value

    normalized_list = []
    for value in values:
        normalized_value = (value - smallest_value) / range_value
        normalized_list.append(normalized_value)

    return normalized_list
# method name: rescale_to_unit -> normalize_values
# parameter name: numbers -> values
# variable name: min_number -> smallest_value, max_number -> largest_value
# introduced range_value to store the difference between largest and smallest values
# replaced list comprehension with a for loop to append each normalized value