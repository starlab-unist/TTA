from typing import List
import collections


def filter_unique_elements(num_list: List[int]) -> List[int]:
    count_map = collections.Counter(num_list)
    unique_numbers = [num for num in num_list if count_map[num] == 1]
    return unique_numbers

# method name: remove_duplicates -> filter_unique_elements
# parameter name: numbers -> num_list
# variable name: c -> count_map
# changed the condition in list comprehension from c[n] <= 1 to count_map[num] == 1 for clarity
# added a separate line for return statement for better readability