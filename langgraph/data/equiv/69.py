def find_max_frequency_index(numbers):
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

# method name: search -> find_max_frequency_index
# parameter name: lst -> numbers
# variable name: frq -> frequency_array, ans -> result
# changed for loop to while loop for the second iteration
# used index variable for clarity in the while loop