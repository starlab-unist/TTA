from typing import List, Tuple

def compute_cumulative_maxima(nums: List[int]) -> List[int]:
    max_so_far = None
    max_values = []
    position = 0
    while position < len(nums):
        current_value = nums[position]
        if max_so_far is None:
            max_so_far = current_value
        else:
            max_so_far = max(max_so_far, current_value)
        max_values.append(max_so_far)
        position += 1
    return max_values
# method name: rolling_max -> compute_cumulative_maxima
# parameter name: numbers -> nums
# variable names: running_max -> max_so_far, result -> max_values
# control structure: for loop replaced with while loop
# loop variable names: n -> current_value, index handled via position
# descriptive naming for variables (max_values instead of result)