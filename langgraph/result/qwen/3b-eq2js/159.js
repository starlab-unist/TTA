function consume(quantity, requirement, stock) {
    const updatedQuantity = requirement <= stock ? quantity + requirement : quantity + stock;
    const leftoverStock = requirement <= stock ? stock - requirement : 0;

    return [updatedQuantity, leftoverStock];
}