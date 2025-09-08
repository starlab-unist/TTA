def organize_even_odd(sequence: list):
    even_elements = sequence[0::2]
    odd_elements = sequence[1::2]
    even_elements.sort()

    result = []
    index = 0
    while index < len(odd_elements):
        result.append(even_elements[index])
        result.append(odd_elements[index])
        index += 1

    if len(even_elements) > len(odd_elements):
        result.append(even_elements[-1])

    return result

# method name: sort_even -> organize_even_odd
# parameter name: l -> sequence
# variable name: evens -> even_elements, odds -> odd_elements, ans -> result
# replaced for loop with while loop for iteration over odd_elements
# used a separate index variable for clarity in the while loop