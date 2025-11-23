from typing import List

def insert_separator(nums: List[int], delimiter: int) -> List[int]:
    if not nums:
        return []
    
    final_list = []
    idx = 0
    while idx < len(nums) - 1:
        final_list.append(nums[idx])
        final_list.append(delimiter)
        idx += 1
    final_list.append(nums[-1])
    return final_list
# method name: intersperse -> insert_separator
# parameter names: numbers -> nums, delimeter -> delimiter (corrected typo)
# variable names: result -> final_list, delimeter -> delimiter, loop variable n -> idx
# changed loop structure from for to while
# replaced numbers[:-1] with index-based loop condition
# corrected 'delimeter' spelling to 'delimiter' in parameter