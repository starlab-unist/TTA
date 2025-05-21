from typing import List

def weave_numbers(sequence: List[int], separator: int) -> List[int]:
    if not sequence:
        return []

    interleaved = []
    index = 0

    while index < len(sequence) - 1:
        interleaved.extend([sequence[index], separator])
        index += 1

    interleaved.append(sequence[-1])

    return interleaved

# method name: intersperse -> weave_numbers
# parameter name: numbers -> sequence, delimeter -> separator
# variable name: result -> interleaved
# replaced for loop with while loop
# used extend instead of append for adding multiple elements