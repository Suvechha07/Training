from collections import deque
import time
import os


def print_maze_with_path(maze, path):
    os.system('cls' if os.name == 'nt' else 'clear')
    for i in range(len(maze)):
        for j in range(len(maze[0])):
            if path and (i, j) == path[-1]:  # Check if path is not empty
                print("\033[94mP\033[0m", end=" ")  # Current position
            elif (i, j) in path:
                print("\033[92mP\033[0m", end=" ")  # Path
            elif maze[i][j] == 0:
                print("#", end=" ")  # Wall
            else:
                print(".", end=" ")  # Walkable space
        print()
    time.sleep(0.5)



def bfs_solve_maze(maze, start, end):
    rows, cols = len(maze), len(maze[0])
    queue = deque([(start, [start])])
    visited = set()
    visited.add(start)

    while queue:
        (x, y), path = queue.popleft()
        print_maze_with_path(maze, path)

        if (x, y) == end:
            return path, len(visited)

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < rows and 0 <= ny < cols and maze[nx][ny] == 1 and (nx, ny) not in visited:
                visited.add((nx, ny))
                queue.append(((nx, ny), path + [(nx, ny)]))

    return [], len(visited)


def dfs_solve_maze(maze, start, end):
    rows, cols = len(maze), len(maze[0])
    stack = [(start, [start])]
    visited = set()
    visited.add(start)

    while stack:
        (x, y), path = stack.pop()
        print_maze_with_path(maze, path)

        if (x, y) == end:
            return path, len(visited)

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < rows and 0 <= ny < cols and maze[nx][ny] == 1 and (nx, ny) not in visited:
                visited.add((nx, ny))
                stack.append(((nx, ny), path + [(nx, ny)]))

    return [], len(visited)


def main():
    maze = [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1],
        [1, 1, 1, 1, 1]
    ]
    start = (0, 0)
    end = (4, 4)

    print("Maze:")
    print_maze_with_path(maze, [])

    print("\nSolving with BFS:")
    bfs_path, bfs_nodes = bfs_solve_maze(maze, start, end)

    print("\nSolving with DFS:")
    dfs_path, dfs_nodes = dfs_solve_maze(maze, start, end)

    print("\nResults:")
    print("BFS:")
    if bfs_path:
        print("Shortest path found:", bfs_path)
        print("Number of nodes explored:", bfs_nodes)
    else:
        print("No path found.")

    print("\nDFS:")
    if dfs_path:
        print("Path found:", dfs_path)
        print("Number of nodes explored:", dfs_nodes)
    else:
        print("No path found.")

    print("\nComparison:")
    print("BFS explored", bfs_nodes, "nodes.")
    print("DFS explored", dfs_nodes, "nodes.")


if __name__ == "__main__":
    main()
