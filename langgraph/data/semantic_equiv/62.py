def compute_derivative(coefficients: list):
    result = []
    index = 1
    while index < len(coefficients):
        result.append(index * coefficients[index])
        index += 1
    return result

# method name: derivative -> compute_derivative
# parameter name: xs -> coefficients
# changed list comprehension to a while loop
# removed slicing by starting the loop from index 1
# used append method to build the result list