def convert_integer_to_minimal_roman(value):
    numeral_values = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    roman_symbols = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"]
    index = len(numeral_values) - 1
    result = ""
    while value > 0:
        quotient = value // numeral_values[index]
        value %= numeral_values[index]
        while quotient > 0:
            result += roman_symbols[index]
            quotient -= 1
        index -= 1
    return result.lower()

# method name: int_to_mini_roman -> convert_integer_to_minimal_roman
# parameter name: number -> value
# variable name: num -> numeral_values, sym -> roman_symbols, i -> index, res -> result
# replaced direct list indexing with len() for clarity
# kept the overall logic and flow similar but with renamed variables and slightly adjusted structure