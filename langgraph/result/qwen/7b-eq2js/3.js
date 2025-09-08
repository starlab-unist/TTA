function checkNegativeBalance(operations) {
    let balance = 0;
    let index = 0;

    while (index < operations.length) {
        balance += operations[index];
        if (balance < 0) {
            return true;
        }
        index++;
    }

    return false;
}