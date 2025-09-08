def extract_distinct_elements(input_list):
    distinct_elements = set(input_list)
    sorted_elements = sorted(distinct_elements)
    return sorted_elements

# method name: unique -> extract_distinct_elements
# parameter name: l -> input_list
# variable name: words -> distinct_elements, counts -> sorted_elements
# replaced list(set(l)) with a more descriptive step-by-step approach