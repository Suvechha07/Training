import heapq


def best_first_search(grid, start, treasure):
    # Define heuristic function (Manhattan distance)
    def heuristic(cell):
        return abs(cell[0] - treasure[0]) + abs(cell[1] - treasure[1])

    # Directions for moving in the grid (right, down, left, up)
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    rows, cols = len(grid), len(grid[0])

    # Priority queue for BFS (min-heap based on heuristic value)
    pq = [(heuristic(start), start)]
    heapq.heapify(pq)

    # Visited set to avoid revisiting nodes
    visited = set()
    visited.add(start)

    # Parent dictionary to reconstruct the path
    parent = {start: None}

    while pq:
        _, current = heapq.heappop(pq)

        # If we reached the treasure, reconstruct the path and return
        if current == treasure:
            path = []
            while current is not None:
                path.append(current)
                current = parent[current]
            return path[::-1]

        # Explore neighbors
        for dir in directions:
            neighbor = (current[0] + dir[0], current[1] + dir[1])
            if 0 <= neighbor[0] < rows and 0 <= neighbor[1] < cols and neighbor not in visited:
                visited.add(neighbor)
                parent[neighbor] = current
                heapq.heappush(pq, (heuristic(neighbor), neighbor))

    # If no path found (normally should not happen if grid is well-formed)
    return None


# Take grid input from the user
def get_input():
    print("Enter the grid dimensions (rows and columns):")
    rows, cols = map(int, input().strip().split())
    print(f"Enter the grid values (row by row, space-separated):")
    grid = []
    for _ in range(rows):
        grid.append(list(map(int, input().strip().split())))

    print("Enter the starting point (row and column, 0-indexed):")
    start = tuple(map(int, input().strip().split()))

    print("Enter the treasure location (row and column, 0-indexed):")
    treasure = tuple(map(int, input().strip().split()))

    return grid, start, treasure


# Main function
if __name__ == "__main__":
    grid, start, treasure = get_input()
    path = best_first_search(grid, start, treasure)
    if path:
        print("Path found:", path)
    else:
        print("No path found to the treasure.")
