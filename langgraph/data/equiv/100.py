def construct_stack(size):
    pile = []
    index = 0
    while index < size:
        pile.append(size + 2 * index)
        index += 1
    return pile
# method name: make_a_pile -> construct_stack
# parameter name: n -> size
# list comprehension replaced with a while loop and list append
# variable name: i -> index, result list renamed to pile