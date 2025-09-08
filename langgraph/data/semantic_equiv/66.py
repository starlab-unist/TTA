def calculate_uppercase_digit_sum(input_string):
    if input_string == "":
        return 0
    
    total_sum = 0
    index = 0
    while index < len(input_string):
        character = input_string[index]
        if character.isupper():
            total_sum += ord(character)
        index += 1
    
    return total_sum

# method name: digitSum -> calculate_uppercase_digit_sum
# parameter name: s -> input_string
# replaced list comprehension with a while loop for iteration
# used an explicit if statement inside the loop to check for uppercase characters
# renamed 'char' to 'character' and introduced 'total_sum' for clarity