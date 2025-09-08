function skjkasdkd(lst) {
    function isPrime(n) {
        for (let i = 2; i <= Math.sqrt(n); i++) {
            if (n % i === 0) {
                return false;
            }
        }
        return true;
    }

    let maxx = 0;
    let i = 0;
    while (i < lst.length) {
        if (lst[i] > maxx && isPrime(lst[i])) {
            maxx = lst[i];
        }
        i++;
    }

    const result = String(maxx).split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0);
    return result;
}