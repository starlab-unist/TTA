def find_max_divisor(number: int) -> int:
    index = number - 1
    while index > 0:
        if number % index == 0:
            return index
        index -= 1

# method name: largest_divisor -> find_max_divisor
# parameter name: n -> number
# replaced for loop with while loop
# changed range to start from number - 1 and decremented manually
# removed reversed function by initializing index to number - 1