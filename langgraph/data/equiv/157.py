def is_right_angled(x, y, z):
    sides_squared = [x**2, y**2, z**2]
    sides_squared.sort()
    return sides_squared[0] + sides_squared[1] == sides_squared[2]

# method name: right_angle_triangle -> is_right_angled
# parameter names: a, b, c -> x, y, z
# introduced list to store squares of sides and sorted it
# used sorted list indices to check Pythagorean theorem condition