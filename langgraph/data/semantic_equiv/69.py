def find_max_frequency_element(numbers):
    max_value = max(numbers)
    frequency_array = [0] * (max_value + 1)
    
    for number in numbers:
        frequency_array[number] += 1

    result = -1
    index = 1
    while index < len(frequency_array):
        if frequency_array[index] >= index:
            result = index
        index += 1

    return result

# method name: search -> find_max_frequency_element
# parameter name: lst -> numbers
# variable name: frq -> frequency_array, ans -> result
# replaced for loop with while loop for frequency check
# changed the way the maximum frequency element is found using a while loop