def compare_character_sets(string_one: str, string_two: str) -> bool:
    set_of_chars_one = set(string_one)
    set_of_chars_two = set(string_two)
    
    return set_of_chars_one == set_of_chars_two

# method name: same_chars -> compare_character_sets
# parameter names: s0 -> string_one, s1 -> string_two
# created separate variables for the sets of characters for clarity
# maintained the return statement to compare the two sets directly