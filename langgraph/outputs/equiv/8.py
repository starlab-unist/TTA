from typing import List, Tuple

def compute_sum_and_multiply(nums: List[int]) -> Tuple[int, int]:
    total = 0
    product = 1
    index = 0
    while index < len(nums):
        total += nums[index]
        product *= nums[index]
        index += 1
    return total, product

# method name: sum_product -> compute_sum_and_multiply
# parameter name: numbers -> nums
# variable names: sum_value -> total, prod_value -> product
# replaced for loop with while loop using index counter
# simplified variable names (total/product instead of total_sum/total_product)