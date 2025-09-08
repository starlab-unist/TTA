// Source Code
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
    } catch (e) {
        return false;
    }

    return true;
}

// Transformed Code (Semantically Equivalent)
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
        if (e instanceof TypeError || e instanceof SyntaxError) {
            return false;
        }
    }

    return true;
}

// Jest Test Cases
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