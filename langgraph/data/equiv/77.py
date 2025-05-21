def check_perfect_cube(number):
    number = abs(number)
    cube_root = round(number ** (1/3))
    return cube_root ** 3 == number

# method name: iscube -> check_perfect_cube
# parameter name: a -> number
# variable name: a -> number, int(round(a ** (1. / 3))) -> cube_root
# simplified the exponentiation operator from (1. / 3) to (1/3)
# kept the logic of checking if the cube of the rounded cube root equals the original number