from typing import List

def balance_falls_negative(transactions: List[int]) -> bool:
    current_total = 0
    position = 0
    while position < len(transactions):
        current_total += transactions[position]
        if current_total < 0:
            return True
        position += 1
    return False
# method name: below_zero -> balance_falls_negative
# parameter name: operations -> transactions
# variable name: balance -> current_total
# control structure: for loop replaced with while loop using index
# variable name: op -> position
# added descriptive variable names for clarity