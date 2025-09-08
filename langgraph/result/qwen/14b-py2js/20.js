function findClosestElements(numbers) {
    let closestPair = null;
    let distance = null;

    for (let idx = 0; idx < numbers.length; idx++) {
        const elem = numbers[idx];
        for (let idx2 = 0; idx2 < numbers.length; idx2++) {
            const elem2 = numbers[idx2];
            if (idx !== idx2) {
                if (distance === null) {
                    distance = Math.abs(elem - elem2);
                    closestPair = [elem, elem2].sort((a, b) => a - b);
                } else {
                    const newDistance = Math.abs(elem - elem2);
                    if (newDistance < distance) {
                        distance = newDistance;
                        closestPair = [elem, elem2].sort((a, b) => a - b);
                    }
                }
            }
        }
    }

    return closestPair;
}