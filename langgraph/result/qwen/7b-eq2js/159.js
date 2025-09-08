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
// method name: consume
// parameter names: quantity, requirement, stock
// replaced if-else with a more descriptive block structure
// renamed variables for clarity: updated_quantity, leftover_stock