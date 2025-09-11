public String evaluateAndCompare(String value1, String value2) {
    String tempA = value1;
    String tempB = value2;

    if (tempA instanceof String) {
        tempA = tempA.replace(',', '.');
    }
    if (tempB instanceof String) {
        tempB = tempB.replace(',', '.');
    }

    double numericVal1 = Double.parseDouble(tempA);
    double numericVal2 = Double.parseDouble(tempB);

    if (numericVal1 == numericVal2) {
        return null;
    } else if (numericVal1 > numericVal2) {
        return value1;
    } else {
        return value2;
    }
}