def can_it_ascend(payload, max_weight):
    if sum(payload) > max_weight:
        return False

    start, end = 0, len(payload) - 1
    while start < end:
        if payload[start] != payload[end]:
            return False
        start += 1
        end -= 1
    return True

# method name: will_it_fly -> can_it_ascend
# parameter name: q -> payload, w -> max_weight
# variable name: i -> start, j -> end
# kept the same logic and structure, just renamed variables and parameters for clarity