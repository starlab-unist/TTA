def findMinimumPathValues(matrix, count):
    size = len(matrix)
    minimum_value = size * size + 1
    for row in range(size):
        for col in range(size):
            if matrix[row][col] == 1:
                neighbors = []
                if row > 0:
                    neighbors.append(matrix[row - 1][col])

                if col > 0:
                    neighbors.append(matrix[row][col - 1])

                if row < size - 1:
                    neighbors.append(matrix[row + 1][col])

                if col < size - 1:
                    neighbors.append(matrix[row][col + 1])

                minimum_value = min(neighbors)

    result = []
    index = 0
    while index < count:
        if index % 2 == 0:
            result.append(1)
        else:
            result.append(minimum_value)
        index += 1

    return result
# method name: minPath -> findMinimumPathValues
# parameter name: grid -> matrix, k -> count
# variable name: n -> size, val -> minimum_value, ans -> result, i -> index
# replaced for loop with while loop for generating the result list
# changed the way neighbors are checked using if conditions