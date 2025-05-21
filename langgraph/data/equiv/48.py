def check_palindrome(sequence: str):
    index = 0
    length = len(sequence)
    
    while index < length // 2:
        if sequence[index] != sequence[length - index - 1]:
            return False
        index += 1
    return True

# method name: is_palindrome -> check_palindrome
# parameter name: text -> sequence
# changed for loop to while loop
# introduced index and length variables for clarity
# used length // 2 to reduce unnecessary comparisons