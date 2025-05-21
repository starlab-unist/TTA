from typing import List


def check_negative_balance(transactions: List[int]) -> bool:
    current_balance = 0

    index = 0
    while index < len(transactions):
        current_balance += transactions[index]
        if current_balance < 0:
            return True
        index += 1

    return False

# method name: below_zero -> check_negative_balance
# parameter name: operations -> transactions
# variable name: balance -> current_balance
# changed for loop to while loop with index increment