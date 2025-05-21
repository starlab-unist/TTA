def compute_special_product(n):
    current_factorial = 1
    cumulative_product = 1
    index = 1

    while index <= n:
        current_factorial *= index
        cumulative_product *= current_factorial
        index += 1

    return cumulative_product

# method name: special_factorial -> compute_special_product
# parameter name: n -> n (remained the same as it's descriptive)
# variable name: fact_i -> current_factorial, special_fact -> cumulative_product
# changed for loop to while loop
# introduced index variable to replace loop variable i
# incremented index manually within the loop