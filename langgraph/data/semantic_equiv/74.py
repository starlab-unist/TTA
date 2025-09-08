def compare_string_lists(list_a, list_b):
    length_a = sum(len(string) for string in list_a)
    
    length_b = 0
    iterator = iter(list_b)
    while True:
        try:
            length_b += len(next(iterator))
        except StopIteration:
            break
    
    return list_a if length_a <= length_b else list_b

# method name: total_match -> compare_string_lists
# parameter names: lst1 -> list_a, lst2 -> list_b
# replaced the for loop with a generator expression for length_a
# replaced the second for loop with a while loop using an iterator for length_b
# simplified the return statement using a conditional expression