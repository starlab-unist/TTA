from typing import List, Tuple


def determine_nearest_pair(values: List[float]) -> Tuple[float, float]:
    nearest_pair = None
    min_gap = None

    index = 0
    while index < len(values):
        inner_index = 0
        while inner_index < len(values):
            if index != inner_index:
                current_difference = abs(values[index] - values[inner_index])
                if min_gap is None or current_difference < min_gap:
                    min_gap = current_difference
                    nearest_pair = tuple(sorted([values[index], values[inner_index]]))
            inner_index += 1
        index += 1

    return nearest_pair

# method name: find_closest_elements -> determine_nearest_pair
# parameter name: numbers -> values
# variable name: closest_pair -> nearest_pair, distance -> min_gap
# changed for loops to while loops
# simplified the initial check for min_gap