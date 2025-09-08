def find_coordinates(matrix, target):
    positions = []
    for row_index in range(len(matrix)):
        for col_index in range(len(matrix[row_index])):
            if matrix[row_index][col_index] == target:
                positions.append((row_index, col_index))

    sorted_positions = sorted(positions, key=lambda pos: pos[1], reverse=True)
    final_sorted_positions = sorted(sorted_positions, key=lambda pos: pos[0])
    return final_sorted_positions

# method name: get_row -> find_coordinates
# parameter name: lst -> matrix, x -> target
# replaced list comprehension with nested for loops
# separated sorting steps for clarity
# variable name: coords -> positions, sorted_coords -> sorted_positions, final_sorted_positions added for clarity