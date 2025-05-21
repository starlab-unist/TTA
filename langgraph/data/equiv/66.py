def calculate_uppercase_ascii_sum(input_string):
    if input_string == "":
        return 0
    
    total = 0
    for character in input_string:
        if character.isupper():
            total += ord(character)
    
    return total
# method name: digitSum -> calculate_uppercase_ascii_sum
# parameter name: s -> input_string
# replaced the generator expression with a for loop
# introduced a 'total' variable to accumulate the sum
# used if statement inside the loop to check for uppercase characters