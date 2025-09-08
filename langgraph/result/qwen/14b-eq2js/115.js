const math = require('mathjs');

function calculateMaxLoad(matrix, limit) {
    let totalLoad = 0;
    for (let row of matrix) {
        totalLoad += math.ceil(math.sum(row) / limit);
    }
    return totalLoad;
}

// method name: max_fill -> calculateMaxLoad
// parameter name: grid -> matrix, capacity -> limit
// replaced list comprehension with a for loop to iterate over rows
// used a running total (totalLoad) instead of summing a list comprehension directly