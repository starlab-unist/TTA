def check_sequence_order(sequence):
    digit_count = {num: 0 for num in sequence}
    for number in sequence:
        digit_count[number] += 1

    if any(digit_count[num] > 2 for num in sequence):
        return False

    index = 1
    while index < len(sequence):
        if sequence[index - 1] > sequence[index]:
            return False
        index += 1

    return True

# method name: is_sorted -> check_sequence_order
# parameter name: lst -> sequence
# variable name: count_digit -> digit_count
# replaced list comprehension with dictionary comprehension for digit_count
# changed the all() with a while loop for checking sorted order
# simplified the return statement by removing the else clause