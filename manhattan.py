import numpy as np

# Define the start and goal states
start_state = [
    [1, 2, 4],
    [5, 0, 0],
    [3, 6, 8]
]

goal_state = [
    [1, 4, 7],
    [2, 5, 8],
    [3, 6, 0]
]


# Find the position of a number in a 2D list
def find_position(state, number):
    for i in range(len(state)):
        for j in range(len(state[i])):
            if state[i][j] == number:
                return i, j
    return None  # If the number is not found, return None


# Calculate Manhattan Distance
def calculate_manhattan_distance(start, goal):
    distance = 0
    moves = {}  # To track the number of moves for each tile
    for number in range(1, 9):  # For tiles 1 through 8 (not including 0)
        start_pos = find_position(start, number)
        goal_pos = find_position(goal, number)

        # Check if positions were found for both start and goal
        if start_pos is None or goal_pos is None:
            print(f"Error: Tile {number} not found in the states.")
            continue

        manhattan_distance = abs(start_pos[0] - goal_pos[0]) + abs(start_pos[1] - goal_pos[1])
        distance += manhattan_distance
        moves[number] = manhattan_distance
    return distance, moves


# Solve the puzzle (assuming input is always solvable)
def solve_puzzle(start, goal):
    total_manhattan_distance, moves = calculate_manhattan_distance(start, goal)
    return total_manhattan_distance, moves


# Main
manhattan_distance, tile_moves = solve_puzzle(start_state, goal_state)

# Print results
print(f"Total Manhattan Distance: {manhattan_distance}")
print("Number of moves for each tile to reach goal:")
for tile, moves in tile_moves.items():
    print(f"Tile {tile}: {moves} moves")
