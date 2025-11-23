function checkNegativeBalance(transactions) {
    let currentBalance = 0;

    let index = 0;
    while (index < transactions.length) {
        currentBalance += transactions[index];
        if (currentBalance < 0) {
            return true;
        }
        index += 1;
    }

    return false;
}