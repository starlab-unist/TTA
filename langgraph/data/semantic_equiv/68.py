def extract_min_even_and_index(numbers):
    if not numbers:
        return []

    even_numbers = [num for num in numbers if num % 2 == 0]
    if not even_numbers:
        return []

    smallest_even = min(even_numbers)
    index_of_smallest_even = numbers.index(smallest_even)

    return [smallest_even, index_of_smallest_even]
# method name: pluck -> extract_min_even_and_index
# parameter name: arr -> numbers
# replaced filter with list comprehension
# used if not numbers and if not even_numbers for empty checks
# separated the calculation of smallest_even and index_of_smallest_even for clarity