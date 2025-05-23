def rearrange_even_odd(numbers: list):
    even_elements = numbers[::2]
    odd_elements = numbers[1::2]
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

# method name: sort_even -> rearrange_even_odd
# parameter name: l -> numbers
# variable name: evens -> even_elements, odds -> odd_elements, ans -> result
# replaced the for loop with a while loop
# kept the logic of extending the result list with both even and odd elements
# maintained the condition to append the last even element if there are more even elements than odd ones