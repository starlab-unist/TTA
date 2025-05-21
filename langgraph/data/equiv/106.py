def generate_alternating_sequence(limit):
    result = []
    index = 1
    while index <= limit:
        if index % 2 == 0:
            factorial = 1
            inner_index = 1
            while inner_index <= index:
                factorial *= inner_index
                inner_index += 1
            result.append(factorial)
        else:
            summation = 0
            inner_index = 1
            while inner_index <= index:
                summation += inner_index
                inner_index += 1
            result.append(summation)
        index += 1
    return result

# method name: f -> generate_alternating_sequence
# parameter name: n -> limit
# variable name: ret -> result, i -> index, x -> factorial/summation, j -> inner_index
# replaced for loops with while loops
# split the calculation of factorial and summation into separate blocks
# used append method for adding elements to the list instead of using +=