def evaluate_difference(actual, player_guess):
    differences = []
    index = 0
    while index < len(actual):
        differences.append(abs(actual[index] - player_guess[index]))
        index += 1
    return differences

# method name: compare -> evaluate_difference
# parameter name: game -> actual, guess -> player_guess
# list comprehension replaced with while loop and append method
# introduced index variable for iteration