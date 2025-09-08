def count_odds_in_lists(list_of_lists):
    result = []
    for sub_list in list_of_lists:
        odd_count = sum(1 for element in sub_list if int(element) % 2 != 0)
        message = f"the number of odd elements {odd_count}n the str{odd_count}ng {odd_count} of the {odd_count}nput."
        result.append(message)
    return result

# method name: odd_count -> count_odds_in_lists
# parameter name: lst -> list_of_lists
# variable name: res -> result, arr -> sub_list, n -> odd_count
# replaced the generator expression with a more explicit form using sum and if condition
# used f-string for constructing the message string