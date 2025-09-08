// Source Code
function totalMatch(lst1, lst2) {
    let l1 = 0;
    for (let st of lst1) {
        l1 += st.length;
    }

    let l2 = 0;
    for (let st of lst2) {
        l2 += st.length;
    }

    if (l1 <= l2) {
        return lst1;
    } else {
        return lst2;
    }
}

// Transformed Code (Semantically Equivalent)
function compareStringLists(listA, listB) {
    const lengthA = listA.reduce((acc, str) => acc + str.length, 0);
    
    let lengthB = 0;
    let index = 0;
    while (index < listB.length) {
        lengthB += listB[index].length;
        index++;
    }
    
    return lengthA <= lengthB ? listA : listB;
}

// Test Cases
describe('totalMatch vs compareStringLists equivalence tests', () => {
    const testCases = [
        (["hello", "world"], ["hi", "planet"]),
        (["apple", "banana"], ["kiwi", "grape", "melon"]),
        (["one"], ["two", "three"]),
        ([], ["single"]),
        (["same", "length"], ["even", "longer"]),
        (["a", "b", "c"], ["d", "e", "f"]),
        (["short"], ["tiny", "bit"]),
        (["equal"], ["equal"]),
        (["abc"], ["defg"]),
        ([], [])
    ];

    test.each(testCases)('Input: "%j" and "%j"', (inputList1, inputList2) => {
        expect(totalMatch(inputList1, inputList2)).toBe(compareStringLists(inputList1, inputList2))
    });
});