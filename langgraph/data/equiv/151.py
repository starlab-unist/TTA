def calculate_modified_sum(numbers):
    total = 0
    for num in numbers:
        if num > 0 and num % 2 != 0 and isinstance(num, int):
            total += num ** 2
    return total

# method name: double_the_difference -> calculate_modified_sum
# parameter name: lst -> numbers
# replaced list comprehension with a for loop and if conditions
# used isinstance(num, int) instead of checking for "." in str(i) to ensure the number is an integer
# renamed the variable from i to num for better readability
# accumulated the sum in a variable named total instead of using sum() directly on the list comprehension