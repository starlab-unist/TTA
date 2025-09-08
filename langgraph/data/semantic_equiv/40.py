def check_for_zero_sum_triplets(numbers: list):
    length = len(numbers)
    index_i = 0

    while index_i < length:
        index_j = index_i + 1
        while index_j < length:
            index_k = index_j + 1
            while index_k < length:
                if numbers[index_i] + numbers[index_j] + numbers[index_k] == 0:
                    return True
                index_k += 1
            index_j += 1
        index_i += 1

    return False
# method name: triples_sum_to_zero -> check_for_zero_sum_triplets
# parameter name: l -> numbers
# replaced for loops with while loops
# changed variable names: i -> index_i, j -> index_j, k -> index_k
# used a more explicit incrementation in the while loop conditions