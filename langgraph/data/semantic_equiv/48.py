def check_symmetry(sequence: str):
    index = 0
    while index < len(sequence) // 2:
        if sequence[index] != sequence[-index - 1]:
            return False
        index += 1
    return True

# method name: is_palindrome -> check_symmetry
# parameter name: text -> sequence
# changed for loop to while loop
# simplified the loop condition to iterate only half the length of the string
# used negative indexing for comparison