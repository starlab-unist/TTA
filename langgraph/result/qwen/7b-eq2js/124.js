function checkValidDate(date) {
    try {
        date = date.trim();
        const [m, d, y] = date.split('-').map(Number);
        
        if (!(1 <= m && m <= 12)) {
            return false;
        }
        
        if (([1, 3, 5, 7, 8, 10, 12].includes(m) && !(1 <= d && d <= 31)) ||
            ([4, 6, 9, 11].includes(m) && !(1 <= d && d <= 30)) ||
            (m === 2 && !(1 <= d && d <= 29))) {
            return false;
        }

        return true;

    } catch (error) {
        return false;
    }
}