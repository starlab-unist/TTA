def produce_even_numbers(x, y):
    start = max(2, min(x, y))
    end = min(8, max(x, y))

    even_numbers = []
    current = start
    while current <= end:
        if current % 2 == 0:
            even_numbers.append(current)
        current += 1

    return even_numbers
# method name: generate_integers -> produce_even_numbers
# parameter names: a -> x, b -> y
# variable names: lower -> start, upper -> end, counts -> even_numbers
# replaced list comprehension with while loop and if statement
# added current variable to iterate through the range