function rightAngleTriangle(a, b, c) {
    return Math.pow(a, 2) === Math.pow(b, 2) + Math.pow(c, 2) || 
           Math.pow(b, 2) === Math.pow(a, 2) + Math.pow(c, 2) || 
           Math.pow(c, 2) === Math.pow(a, 2) + Math.pow(b, 2);
}