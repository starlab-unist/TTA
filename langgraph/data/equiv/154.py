def verify_cyclic_pattern(sequence, pattern):
    pattern_length = len(pattern)
    doubled_pattern = pattern + pattern
    index = 0
    
    while index <= len(sequence) - pattern_length:
        sub_index = 0
        while sub_index <= pattern_length:
            if sequence[index:index+pattern_length] == doubled_pattern[sub_index:sub_index+pattern_length]:
                return True
            sub_index += 1
        index += 1
    
    return False

# method name: cycpattern_check -> verify_cyclic_pattern
# parameter name: a -> sequence, b -> pattern
# variable name: l -> pattern_length, pat -> doubled_pattern
# changed for loop to while loop for both iterations
# adjusted the range checks to be inclusive of the last possible starting index