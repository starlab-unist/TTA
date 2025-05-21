def count_divisible_triples(limit):
    sequence = [x*x - x + 1 for x in range(1, limit+1)]
    result_count = 0
    
    index_i = 0
    while index_i < limit:
        index_j = index_i + 1
        while index_j < limit:
            index_k = index_j + 1
            while index_k < limit:
                if (sequence[index_i] + sequence[index_j] + sequence[index_k]) % 3 == 0:
                    result_count += 1
                index_k += 1
            index_j += 1
        index_i += 1
    
    return result_count

# method name: get_max_triples -> count_divisible_triples
# parameter name: n -> limit
# list comprehension variable: i -> x
# list name: A -> sequence
# result storage: ans -> result_count (changed from list to counter)
# replaced nested for loops with while loops
# removed the list append and used a counter instead