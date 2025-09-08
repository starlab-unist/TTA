function checkNegativeBalance(transactions) {
    let currentBalance = 0;

    let index = 0;
    while (index < transactions.length) {
        currentBalance += transactions[index];
        if (currentBalance < 0) {
            return true;
        }
        index++;
    }

    return false;
}

// method name: below_zero -> checkNegativeBalance
// parameter name: operations -> transactions
// variable name: balance -> currentBalance
// changed for loop to while loop with index increment