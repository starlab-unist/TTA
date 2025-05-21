def tally_even_odd_digits(number):
    even_tally = 0
    odd_tally = 0
    index = 0
    num_str = str(abs(number))
    
    while index < len(num_str):
        digit = int(num_str[index])
        if digit % 2 == 0:
            even_tally += 1
        else:
            odd_tally += 1
        index += 1
    
    return (even_tally, odd_tally)

# method name: even_odd_count -> tally_even_odd_digits
# parameter name: num -> number
# variable names: even_count -> even_tally, odd_count -> odd_tally
# replaced for loop with while loop and index increment
# kept the logic and return type the same