def compare_parity(list_a, list_b):
    odd_count = 0
    even_count = 0
    index = 0
    
    while index < len(list_a):
        if list_a[index] % 2 != 0:
            odd_count += 1
        index += 1
    
    index = 0
    while index < len(list_b):
        if list_b[index] % 2 == 0:
            even_count += 1
        index += 1
    
    return "YES" if even_count >= odd_count else "NO"

# method name: exchange -> compare_parity
# parameter names: lst1 -> list_a, lst2 -> list_b
# variable names: odd -> odd_count, even -> even_count
# replaced for loops with while loops
# used a single index variable for both lists
# simplified the return statement using a conditional expression