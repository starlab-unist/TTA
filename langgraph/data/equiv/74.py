def compare_string_lists(list_a, list_b):
    length_a = sum(len(string) for string in list_a)
    
    length_b = 0
    index = 0
    while index < len(list_b):
        length_b += len(list_b[index])
        index += 1
    
    if length_a <= length_b:
        return list_a
    return list_b

# method name: total_match -> compare_string_lists
# parameter names: lst1 -> list_a, lst2 -> list_b
# replaced the for loop with a generator expression for length_a
# replaced the second for loop with a while loop for length_b
# simplified the return statement by removing the else clause