def check_identical_characters(string_one: str, string_two: str):
    characters_set_one = set(string_one)
    characters_set_two = set(string_two)

    return characters_set_one == characters_set_two

# method name: same_chars -> check_identical_characters
# parameter names: s0 -> string_one, s1 -> string_two
# created separate variables for the sets of each string for clarity