function findClosestElements(numbers) {
    let closestPair = null;
    let distance = null;

    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (i !== j) {
                if (distance === null) {
                    distance = Math.abs(numbers[i] - numbers[j]);
                    closestPair = [numbers[i], numbers[j]].sort((a, b) => a - b);
                } else {
                    const newDistance = Math.abs(numbers[i] - numbers[j]);
                    if (newDistance < distance) {
                        distance = newDistance;
                        closestPair = [numbers[i], numbers[j]].sort((a, b) => a - b);
                    }
                }
            }
        }
    }

    return closestPair;
}