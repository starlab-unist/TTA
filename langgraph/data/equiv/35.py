def find_maximum_value(elements: list):
    current_max = elements[0]
    index = 1
    while index < len(elements):
        if elements[index] > current_max:
            current_max = elements[index]
        index += 1
    return current_max

# method name: max_element -> find_maximum_value
# parameter name: l -> elements
# variable name: m -> current_max
# changed for loop to while loop
# introduced index variable to iterate through the list