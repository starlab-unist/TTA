def validate_parentheses(sequence: str):
    balance = 0
    index = 0
    while index < len(sequence):
        if sequence[index] == '(':
            balance += 1
        elif sequence[index] == ')':
            balance -= 1
        if balance < 0:
            return False
        index += 1
    return balance == 0

# method name: correct_bracketing -> validate_parentheses
# parameter name: brackets -> sequence
# variable name: depth -> balance
# changed for loop to while loop
# replaced increment and decrement with index tracking