def find_planets_between(body1, body2):
    solar_system = ("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    if body1 not in solar_system or body2 not in solar_system or body1 == body2:
        return tuple()
    
    index1 = solar_system.index(body1)
    index2 = solar_system.index(body2)
    
    if index1 < index2:
        return solar_system[index1 + 1:index2]
    else:
        return solar_system[index2 + 1:index1]

# method name: bf -> find_planets_between
# parameter names: planet1 -> body1, planet2 -> body2
# variable name: planet_names -> solar_system
# replaced empty tuple creation: () -> tuple()
# kept slicing logic but used more descriptive variable names