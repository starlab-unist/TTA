def check_prime_string_length(input_text):
    string_length = len(input_text)
    if string_length < 2:
        return False
    divisor = 2
    while divisor < string_length:
        if string_length % divisor == 0:
            return False
        divisor += 1
    return True

# method name: prime_length -> check_prime_string_length
# parameter name: string -> input_text
# variable name: l -> string_length, i -> divisor
# replaced for loop with while loop
# simplified the initial if condition to string_length < 2