function belowZero(operations) {
    let balance = 0;

    for (let op of operations) {
        balance += op;
        if (balance < 0) {
            return true;
        }
    }

    return false;
}