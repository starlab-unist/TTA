def calculate_modified_sum(numbers):
    total = 0
    index = 0
    while index < len(numbers):
        if index % 3 == 0:
            total += numbers[index] ** 2
        elif index % 4 == 0:
            total += numbers[index] ** 3
        else:
            total += numbers[index]
        index += 1
    return total

# method name: sum_squares -> calculate_modified_sum
# parameter name: lst -> numbers
# changed for loop to while loop
# removed intermediate list 'result' and directly added to 'total'
# simplified the else condition by removing the redundant check `i%3 != 0`
# used direct addition to 'total' instead of appending to a list and then summing