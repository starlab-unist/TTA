def compute_derivative(coefficients: list):
    result = []
    index = 1
    while index < len(coefficients):
        result.append(index * coefficients[index])
        index += 1
    return result
# method name: derivative -> compute_derivative
# parameter name: xs -> coefficients
# replaced list comprehension with while loop
# used an explicit index variable to iterate through the list
# started the loop from index 1 to skip the first element