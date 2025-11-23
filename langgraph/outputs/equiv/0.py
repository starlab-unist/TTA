from typing import List
import itertools

def contains_nearby_pairs(values: List[float], max_distance: float) -> bool:
    for first, second in itertools.combinations(values, 2):
        if abs(first - second) < max_distance:
            return True
    return False
# method name: has_close_elements -> contains_nearby_pairs
# parameter names: numbers -> values, threshold -> max_distance
# replaced nested loops with itertools.combinations for pair generation
# used descriptive variable names first/second instead of idx/idx2
# simplified distance check with direct comparison