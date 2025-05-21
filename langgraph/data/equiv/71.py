def compute_triangle_area(side1, side2, side3):
    if side1 + side2 <= side3 or side1 + side3 <= side2 or side2 + side3 <= side1:
        return -1
    
    semi_perimeter = (side1 + side2 + side3) / 2
    computed_area = (semi_perimeter * (semi_perimeter - side1) * (semi_perimeter - side2) * (semi_perimeter - side3)) ** 0.5
    rounded_area = round(computed_area, 2)
    
    return rounded_area

# method name: triangle_area -> compute_triangle_area
# parameter names: a -> side1, b -> side2, c -> side3
# variable name: s -> semi_perimeter, area -> computed_area
# introduced an intermediate variable rounded_area for clarity