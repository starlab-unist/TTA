function validDate(date) {
    try {
        date = date.trim();
        const [month, day, year] = date.split('-').map(Number);
        if (month < 1 || month > 12) {
            return false;
        }
        if ([1, 3, 5, 7, 8, 10, 12].includes(month) && (day < 1 || day > 31)) {
            return false;
        }
        if ([4, 6, 9, 11].includes(month) && (day < 1 || day > 30)) {
            return false;
        }
        if (month === 2 && (day < 1 || day > 29)) {
            return false;
        }
    } catch {
        return false;
    }

    return true;
}