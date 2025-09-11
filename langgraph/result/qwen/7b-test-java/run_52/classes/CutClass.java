public boolean allElementsUnderLimit(List<Integer> elements, int threshold) {
    int index = 0;
    while (index < elements.size()) {
        if (elements.get(index) >= threshold) {
            return false;
        }
        index += 1;
    }
    return true;
}