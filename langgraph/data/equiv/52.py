def all_elements_under_limit(elements: list, threshold: int):
    index = 0
    while index < len(elements):
        if elements[index] >= threshold:
            return False
        index += 1
    return True

# method name: below_threshold -> all_elements_under_limit
# parameter name: l -> elements, t -> threshold
# replaced for loop with while loop
# used index to iterate through the list
# kept the return values the same