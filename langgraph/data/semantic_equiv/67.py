def calculate_remaining_fruits(fruit_string, total_fruits):
    number_list = []
    for item in fruit_string.split():
        if item.isdigit():
            number_list.append(int(item))
    remaining_fruits = total_fruits - sum(number_list)
    return remaining_fruits

# method name: fruit_distribution -> calculate_remaining_fruits
# parameter name: s -> fruit_string, n -> total_fruits
# variable name: lis -> number_list
# replaced 'for i in s.split(' ')' with 'for item in fruit_string.split()' for better readability
# introduced a new variable 'remaining_fruits' to store the result before returning it