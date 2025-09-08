from typing import List

def compute_rolling_maximum(values: List[int]) -> List[int]:
    current_max = None
    max_history = []

    index = 0
    while index < len(values):
        if current_max is None:
            current_max = values[index]
        elif values[index] > current_max:
            current_max = values[index]

        max_history.append(current_max)
        index += 1

    return max_history

# method name: rolling_max -> compute_rolling_maximum
# parameter name: numbers -> values
# variable name: running_max -> current_max, result -> max_history
# replaced for loop with while loop and index increment
# simplified the condition for updating current_max