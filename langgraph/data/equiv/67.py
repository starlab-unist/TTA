def calculate_remaining_fruits(fruit_string, total_fruits):
    numbers = []
    for item in fruit_string.split():
        if item.isdigit():
            numbers.append(int(item))
    remaining_fruits = total_fruits - sum(numbers)
    return remaining_fruits

# method name: fruit_distribution -> calculate_remaining_fruits
# parameter name: s -> fruit_string, n -> total_fruits
# variable name: lis -> numbers
# replaced 'split(' ')' with 'split()' which is equivalent for splitting by spaces
# introduced a new variable 'remaining_fruits' to store the result before returning