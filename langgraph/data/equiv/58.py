def find_shared_elements(list_a: list, list_b: list):
    shared_items = set()
    iterator_a = iter(list_a)
    
    while True:
        try:
            element_a = next(iterator_a)
            for element_b in list_b:
                if element_a == element_b:
                    shared_items.add(element_a)
        except StopIteration:
            break
    
    return sorted(list(shared_items))

# method name: common -> find_shared_elements
# parameter names: l1 -> list_a, l2 -> list_b
# variable name: ret -> shared_items
# replaced the nested for loop with a while loop and iterator
# added exception handling for the iterator to break the loop
# kept the return statement structure similar but used the new variable name