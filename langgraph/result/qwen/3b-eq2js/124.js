function checkValidDate(d) {
    try {
        d = d.trim();
        const [m, d, y] = d.split('-').map(Number);
        
        if (m < 1 || m > 12) return false;
        
        const daysInMonth = new Set([1, 3, 5, 7, 8, 10, 12]);
        if (daysInMonth.has(m) && (d < 1 || d > 31)) return false;
        
        const monthsWith30Days = new Set([4, 6, 9, 11]);
        if (monthsWith30Days.has(m) && (d < 1 || d > 30)) return false;
        
        if (m === 2 && (d < 1 || d > 29)) return false;
    
    } catch (error) {
        return false;
    }

    return true;
}