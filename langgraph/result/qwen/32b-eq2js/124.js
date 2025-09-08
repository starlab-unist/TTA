function checkValidDate(d) {
    try {
        d = d.trim();
        const [m, d, y] = d.split('-').map(Number);
        
        if (!(1 <= m && m <= 12)) {
            return false;
        }
        
        if ([1, 3, 5, 7, 8, 10, 12].includes(m) && !(1 <= d && d <= 31)) {
            return false;
        }
        
        if ([4, 6, 9, 11].includes(m) && !(1 <= d && d <= 30)) {
            return false;
        }
        
        if (m === 2 && !(1 <= d && d <= 29)) {
            return false;
        }
    
    } catch (e) {
        return false;
    }

    return true;
}