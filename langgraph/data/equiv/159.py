def consume(quantity, requirement, stock):
    if requirement <= stock:
        updated_quantity = quantity + requirement
        leftover_stock = stock - requirement
    else:
        updated_quantity = quantity + stock
        leftover_stock = 0

    return [updated_quantity, leftover_stock]
# method name: eat -> consume
# parameter name: number -> quantity, need -> requirement, remaining -> stock
# replaced if-else with a more descriptive block structure
# renamed variables for clarity: number -> updated_quantity, remaining -> leftover_stock