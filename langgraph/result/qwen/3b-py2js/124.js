function validDate(date) {
    try {
        date = date.trim();
        const parts = date.split('-');
        const month = parseInt(parts[0], 10);
        const day = parseInt(parts[1], 10);
        const year = parseInt(parts[2], 10);

        if (month < 1 || month > 12) {
            return false;
        }
        if (month === 2 && day < 1 || day > 29) {
            return false;
        }
        if ((month === 4 || month === 6 || month === 9 || month === 11) && day < 1 || day > 30) {
            return false;
        }
        if ((month === 1 || month === 3 || month === 5 || month === 7 || month === 8 || month === 10 || month === 12) && day < 1 || day > 31) {
            return false;
        }
    } catch {
        return false;
    }

    return true;
}