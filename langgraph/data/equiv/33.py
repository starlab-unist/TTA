def arrange_every_third_element(input_list: list):
    elements_to_sort = input_list[::3]
    elements_to_sort.sort()
    result_list = list(input_list)
    for index, value in enumerate(elements_to_sort):
        result_list[index * 3] = value
    return result_list

# method name: sort_third -> arrange_every_third_element
# parameter name: l -> input_list
# created a separate list elements_to_sort for clarity
# used a for loop to place sorted elements back into their positions
# changed the way the sorted elements are placed back into the list