from typing import List, Any

def extract_integers(data: List[Any]) -> List[int]:
    result = []
    for item in data:
        if isinstance(item, int):
            result.append(item)
    return result

# method name: filter_integers -> extract_integers
# parameter name: values -> data
# changed list comprehension to a for loop with append