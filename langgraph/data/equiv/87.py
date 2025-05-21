def find_coordinates(matrix, target):
    positions = []
    for row_index, row in enumerate(matrix):
        for col_index, value in enumerate(row):
            if value == target:
                positions.append((row_index, col_index))

    sorted_positions = sorted(positions, key=lambda pos: pos[1], reverse=True)
    final_sorted_positions = sorted(sorted_positions, key=lambda pos: pos[0])
    return final_sorted_positions

# method name: get_row -> find_coordinates
# parameter name: lst -> matrix, x -> target
# list comprehension replaced with nested for loops
# variable name: coords -> positions
# split sorting into two steps for clarity