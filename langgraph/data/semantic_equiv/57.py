def check_monotonic_sequence(sequence: list):
    ascending = all(x <= y for x, y in zip(sequence, sequence[1:]))
    descending = all(x >= y for x, y in zip(sequence, sequence[1:]))

    return ascending or descending
# method name: monotonic -> check_monotonic_sequence
# parameter name: l -> sequence
# replaced sorting with direct comparison using zip and all()
# used two separate variables for ascending and descending checks