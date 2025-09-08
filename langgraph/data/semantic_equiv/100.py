def construct_stone_stack(size):
    pile = []
    index = 0
    while index < size:
        pile.append(size + 2 * index)
        index += 1
    return pile

# method name: make_a_pile -> construct_stone_stack
# parameter name: n -> size
# list comprehension replaced with while loop and list append
# variable name: i -> index
# introduced an empty list 'pile' to collect results