def calculate_even_index_odd_values_sum(numbers):
    total = 0
    index = 0
    while index < len(numbers):
        if index % 2 == 0 and numbers[index] % 2 == 1:
            total += numbers[index]
        index += 1
    return total

# method name: solution -> calculate_even_index_odd_values_sum
# parameter name: lst -> numbers
# replaced list comprehension with a while loop
# introduced a total variable to accumulate the sum
# used a while loop with an index variable instead of enumerate