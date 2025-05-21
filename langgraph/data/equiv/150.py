def determine_value_based_on_divisibility(number, value_if_not_prime, value_if_prime):
    if number == 1:
        return value_if_prime

    divisor = 2
    while divisor < number:
        if number % divisor == 0:
            return value_if_prime
        divisor += 1
    else:
        return value_if_not_prime

# method name: x_or_y -> determine_value_based_on_divisibility
# parameter name: n -> number, x -> value_if_not_prime, y -> value_if_prime
# replaced for loop with while loop
# removed unnecessary break statement after return
# changed the logic slightly to use a while loop for checking divisibility