def count_occurrences(main_str: str, sub_str: str) -> int:
    occurrence_count = 0
    index = 0

    while index <= len(main_str) - len(sub_str):
        if main_str[index:index+len(sub_str)] == sub_str:
            occurrence_count += 1
        index += 1

    return occurrence_count

# method name: how_many_times -> count_occurrences
# parameter name: string -> main_str, substring -> sub_str
# variable name: times -> occurrence_count, i -> index
# replaced for loop with while loop
# adjusted the condition in the while loop for clarity