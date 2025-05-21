def get_row(lst, x):
    coords = [(i, j) for i in range(len(lst)) for j in range(len(lst[i])) if lst[i][j] == x]
    return sorted(sorted(coords, key=lambda x: x[1], reverse=True), key=lambda x: x[0])


def find_coordinates(matrix, target):
    positions = []
    for row_index, row in enumerate(matrix):
        for col_index, value in enumerate(row):
            if value == target:
                positions.append((row_index, col_index))

    sorted_positions = sorted(positions, key=lambda pos: pos[1], reverse=True)
    final_sorted_positions = sorted(sorted_positions, key=lambda pos: pos[0])
    return final_sorted_positions

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 5),
        ([[1, 1, 1], [1, 1, 1], [1, 1, 1]], 1),
        ([[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0),
        ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 10),
        ([[1, 2, 3], [3, 4, 5], [5, 6, 7]], 3),
        ([[10, 20, 30], [40, 50, 60], [70, 80, 90]], 60),
        ([['a', 'b'], ['c', 'd'], ['e', 'f']], 'd'),
        ([['x', 'y', 'z'], ['x', 'y', 'z'], ['x', 'y', 'z']], 'x'),
        ([[1, 2], [3, 4]], 4),
        ([[7, 8], [9, 10], [11, 12]], 7)
    ]

    def test_0(self):
        self.assertEqual(get_row(self.test_cases[0][0], self.test_cases[0][1]), find_coordinates(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(get_row(self.test_cases[1][0], self.test_cases[1][1]), find_coordinates(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(get_row(self.test_cases[2][0], self.test_cases[2][1]), find_coordinates(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(get_row(self.test_cases[3][0], self.test_cases[3][1]), find_coordinates(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(get_row(self.test_cases[4][0], self.test_cases[4][1]), find_coordinates(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(get_row(self.test_cases[5][0], self.test_cases[5][1]), find_coordinates(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(get_row(self.test_cases[6][0], self.test_cases[6][1]), find_coordinates(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(get_row(self.test_cases[7][0], self.test_cases[7][1]), find_coordinates(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(get_row(self.test_cases[8][0], self.test_cases[8][1]), find_coordinates(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(get_row(self.test_cases[9][0], self.test_cases[9][1]), find_coordinates(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()