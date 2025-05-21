def evaluate_expression(operators, values):
    result_string = str(values[0])
    index = 0
    while index < len(operators):
        result_string += operators[index] + str(values[index + 1])
        index += 1
    return eval(result_string)

# method name: do_algebra -> evaluate_expression
# parameter name: operator -> operators, operand -> values
# changed for loop to while loop
# used index variable to iterate through operators and values
# kept the logic of constructing the expression string and evaluating it