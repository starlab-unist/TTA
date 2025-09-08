function consume(quantity, requirement, stock) {
    let updatedQuantity;
    let leftoverStock;

    if (requirement <= stock) {
        updatedQuantity = quantity + requirement;
        leftoverStock = stock - requirement;
    } else {
        updatedQuantity = quantity + stock;
        leftoverStock = 0;
    }

    return [updatedQuantity, leftoverStock];
}