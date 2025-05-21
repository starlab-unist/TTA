def extract_min_even_and_index(sequence):
    if not sequence:
        return []

    even_numbers = [num for num in sequence if num % 2 == 0]
    if not even_numbers:
        return []

    smallest_even = min(even_numbers)
    position_of_smallest_even = sequence.index(smallest_even)

    return [smallest_even, position_of_smallest_even]

# method name: pluck -> extract_min_even_and_index
# parameter name: arr -> sequence
# replaced filter with list comprehension for even numbers
# used if not sequence and if not even_numbers for checks
# changed variable names: evens -> even_numbers, min(evens) -> smallest_even, arr.index(min(evens)) -> position_of_smallest_even
# adjusted the return statement for clarity