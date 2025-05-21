def extract_distinct_elements(input_list):
    distinct_elements = set(input_list)
    sorted_elements = sorted(distinct_elements)
    return sorted_elements

# method name: unique -> extract_distinct_elements
# parameter name: l -> input_list
# variable name: l -> distinct_elements
# introduced an intermediate variable sorted_elements for clarity
# used set and sorted functions in a more explicit manner