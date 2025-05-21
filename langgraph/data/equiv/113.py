def count_odds_in_sublists(input_list):
    result = []
    for sublist in input_list:
        odd_count = sum(1 for digit in sublist if int(digit) % 2 != 0)
        result.append(f"the number of odd elements {odd_count}n the str{odd_count}ng {odd_count} of the {odd_count}nput.")
    return result

# method name: odd_count -> count_odds_in_sublists
# parameter name: lst -> input_list
# variable name: res -> result, arr -> sublist, n -> odd_count
# replaced the generator expression with a more readable sum with a conditional
# used f-string for string formatting instead of concatenation