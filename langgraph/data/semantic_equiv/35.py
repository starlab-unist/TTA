def find_largest_value(numbers: list):
    largest = numbers[0]
    index = 1
    while index < len(numbers):
        if numbers[index] > largest:
            largest = numbers[index]
        index += 1
    return largest

# method name: max_element -> find_largest_value
# parameter name: l -> numbers
# variable name: m -> largest, e -> removed (replaced by indexing)
# changed for loop to while loop
# used indexing instead of direct element access in the loop