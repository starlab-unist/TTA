// Source Code
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

// Transformed Code (Semantically Equivalent)
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

// Test Cases
describe('Function Equivalence', () => {
    const testCases = [
        "01-15-2023",   // valid date
        "02-29-2024",   // valid leap year date
        "04-31-2023",   // invalid date, April has 30 days
        "13-01-2023",   // invalid month
        "00-10-2023",   // invalid month
        "06-00-2023",   // invalid day
        "06-32-2023",   // invalid day
        "02-30-2023",   // invalid date, February has 29 days in a leap year
        "-1-15-2023",   // invalid format
        "01--15-2023",  // invalid format
    ];

    testCases.forEach((testCase, index) => {
        it(`Test case ${index}`, () => {
            expect(validDate(testCase)).toEqual(checkValidDate(testCase));
        });
    });
});