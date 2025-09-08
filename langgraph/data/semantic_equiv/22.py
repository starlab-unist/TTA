from typing import List, Any


def extract_integers(data: List[Any]) -> List[int]:
    result = []
    index = 0
    while index < len(data):
        if isinstance(data[index], int):
            result.append(data[index])
        index += 1
    return result
# method name: filter_integers -> extract_integers
# parameter name: values -> data
# changed list comprehension to while loop with index
# added result list to collect integers