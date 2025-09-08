from typing import List

def contains_nearby_elements(values: List[float], limit: float) -> bool:
    index = 0
    while index < len(values):
        inner_index = 0
        while inner_index < len(values):
            if index != inner_index:
                gap = abs(values[index] - values[inner_index])
                if gap < limit:
                    return True
            inner_index += 1
        index += 1

    return False

# method name: has_close_elements -> contains_nearby_elements
# parameter name: numbers -> values, threshold -> limit
# changed for loop to while loop for both iterations
# variable name: idx -> index, idx2 -> inner_index, elem -> values[index], elem2 -> values[inner_index], distance -> gap
# kept the logic of checking elements and comparing their absolute difference with the threshold