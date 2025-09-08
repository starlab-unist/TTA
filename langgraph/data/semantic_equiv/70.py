def alternate_min_max_sort(input_list):
    result, toggle = [], True
    while input_list:
        selected_value = min(input_list) if toggle else max(input_list)
        result.append(selected_value)
        input_list.remove(selected_value)
        toggle = not toggle
    return result

# method name: strange_sort_list -> alternate_min_max_sort
# parameter name: lst -> input_list
# variable name: res -> result, switch -> toggle
# replaced inline conditional with a separate variable for clarity
# kept the core logic of alternating between min and max