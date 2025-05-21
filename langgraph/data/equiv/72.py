def can_it_take_off(weights, max_weight):
    total_weight = sum(weights)

    if total_weight > max_weight:
        return False

    start, end = 0, len(weights) - 1
    while start < end:
        if weights[start] != weights[end]:
            return False
        start += 1
        end -= 1

    return True

# method name: will_it_fly -> can_it_take_off
# parameter name: q -> weights, w -> max_weight
# variable name: i -> start, j -> end, sum(q) -> total_weight
# replaced direct sum calculation with a variable for clarity
# maintained the while loop structure but renamed indices