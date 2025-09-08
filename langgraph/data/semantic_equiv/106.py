def generate_sequence(limit):
    result = []
    index = 1
    while index <= limit:
        if index % 2 == 0:
            product = 1
            factor = 1
            while factor <= index:
                product *= factor
                factor += 1
            result.append(product)
        else:
            summation = 0
            addend = 1
            while addend <= index:
                summation += addend
                addend += 1
            result.append(summation)
        index += 1
    return result

# method name: f -> generate_sequence
# parameter name: n -> limit
# variable name: ret -> result, i -> index, x -> product/summation, j -> factor/addend
# changed for loops to while loops
# separated the calculation of product and summation into distinct blocks
# used append instead of concatenating lists