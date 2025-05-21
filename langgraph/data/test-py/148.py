# Source Code
def bf(planet1, planet2):
    planet_names = ("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    if planet1 not in planet_names or planet2 not in planet_names or planet1 == planet2:
        return ()
    planet1_index = planet_names.index(planet1)
    planet2_index = planet_names.index(planet2)
    if planet1_index < planet2_index:
        return (planet_names[planet1_index + 1: planet2_index])
    else:
        return (planet_names[planet2_index + 1 : planet1_index])

# Transformed Code (Semantically Equivalent)
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

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("Earth", "Mars"),
        ("Neptune", "Mercury"),
        ("Venus", "Jupiter"),
        ("Saturn", "Saturn"),
        ("Pluto", "Earth"),
        ("Mars", "Mars"),
        ("Mercury", "Neptune"),
        ("Uranus", "Venus"),
        ("Earth", "Earth"),
        ("Jupiter", "Saturn")
    ]

    def test_0(self):
        self.assertEqual(bf(*self.test_cases[0]), find_planets_between(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(bf(*self.test_cases[1]), find_planets_between(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(bf(*self.test_cases[2]), find_planets_between(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(bf(*self.test_cases[3]), find_planets_between(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(bf(*self.test_cases[4]), find_planets_between(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(bf(*self.test_cases[5]), find_planets_between(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(bf(*self.test_cases[6]), find_planets_between(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(bf(*self.test_cases[7]), find_planets_between(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(bf(*self.test_cases[8]), find_planets_between(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(bf(*self.test_cases[9]), find_planets_between(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()