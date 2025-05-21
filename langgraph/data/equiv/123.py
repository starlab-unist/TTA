def extract_odd_numbers_in_sequence(starting_value):
    if starting_value % 2 == 0:
        sequence_of_odds = []
    else:
        sequence_of_odds = [starting_value]

    current_value = starting_value
    while current_value > 1:
        if current_value % 2 == 0:
            current_value //= 2
        else:
            current_value = current_value * 3 + 1

        if current_value % 2 != 0:
            sequence_of_odds.append(current_value)

    return sorted(sequence_of_odds)

# method name: get_odd_collatz -> extract_odd_numbers_in_sequence
# parameter name: n -> starting_value
# variable name: odd_collatz -> sequence_of_odds, n -> current_value
# replaced n = n/2 with n //= 2 for integer division
# changed if n%2 == 1 to if n%2 != 0 for clarity
# kept the logic and output the same