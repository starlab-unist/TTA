// Source Code
function eat(number, need, remaining) {
    if (need <= remaining) {
        return [number + need, remaining - need];
    } else {
        return [number + remaining, 0];
    }
}

// Transformed Code (Semantically Equivalent)
function consume(quantity, requirement, stock) {
    let updated_quantity;
    let leftover_stock;

    if (requirement <= stock) {
        updated_quantity = quantity + requirement;
        leftover_stock = stock - requirement;
    } else {
        updated_quantity = quantity + stock;
        leftover_stock = 0;
    }

    return [updated_quantity, leftover_stock];
}

// Test Cases
describe('eat vs consume equivalence tests', () => {
    const testCases = [
        [10, 5, 8],
        [20, 15, 10],
        [0, 0, 0],
        [1, 2, 3],
        [5, 5, 5],
        [100, 50, 75],
        [42, 99, 10],
        [7, 0, 5],
        [3, 3, 2],
        [8, 10, 8]
    ];

    test.each(testCases)('Input: number=%s, need=%s, remaining=%s', (number, need, remaining) => {
        expect(eat(number, need, remaining)).toEqual(consume(number, need, remaining));
    });
});