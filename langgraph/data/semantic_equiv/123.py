def extract_odd_collatz_values(start_number):
    if start_number % 2 == 0:
        odd_numbers = []
    else:
        odd_numbers = [start_number]

    current_value = start_number
    while current_value > 1:
        if current_value % 2 == 0:
            current_value //= 2
        else:
            current_value = current_value * 3 + 1

        if current_value % 2 == 1:
            odd_numbers.append(current_value)

    return sorted(odd_numbers)

# method name: get_odd_collatz -> extract_odd_collatz_values
# parameter name: n -> start_number
# variable name: odd_collatz -> odd_numbers
# replaced n = n/2 with n //= 2 for integer division
# used current_value instead of n inside the loop for clarity