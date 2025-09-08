function intToMiniRoman(number) {
    const num = [1, 4, 5, 9, 10, 40, 50, 90, 
                100, 400, 500, 900, 1000]; 
    const sym = ["I", "IV", "V", "IX", "X", "XL",  
                "L", "XC", "C", "CD", "D", "CM", "M"]; 
    let i = 12;
    let res = '';
    while (number > 0) { 
        const div = Math.floor(number / num[i]); 
        number %= num[i]; 
        for (let j = 0; j < div; j++) {
            res += sym[i];
        }
        i--;
    }
    return res.toLowerCase();
}