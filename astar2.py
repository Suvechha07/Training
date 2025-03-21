import heapq
import numpy as np
import matplotlib.pyplot as plt
from collections import deque


def heuristic(a, b, method='manhattan'):
    if method == 'manhattan':
        return abs(a[0] - b[0]) + abs(a[1] - b[1])
    elif method == 'euclidean':
        return np.sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2)


def astar(grid, start, goal, method='manhattan'):
    rows, cols = grid.shape
    open_set = []
    heapq.heappush(open_set, (0, start))
    came_from = {}
    g_score = {start: 0}
    f_score = {start: heuristic(start, goal, method)}

    while open_set:
        _, current = heapq.heappop(open_set)
        if current == goal:
            path = []
            while current in came_from:
                path.append(current)
                current = came_from[current]
            return path[::-1]

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]:
            neighbor = (current[0] + dx, current[1] + dy)
            if 0 <= neighbor[0] < rows and 0 <= neighbor[1] < cols and grid[neighbor] == 0:
                temp_g_score = g_score[current] + heuristic(current, neighbor, method)
                if neighbor not in g_score or temp_g_score < g_score[neighbor]:
                    came_from[neighbor] = current
                    g_score[neighbor] = temp_g_score
                    f_score[neighbor] = temp_g_score + heuristic(neighbor, goal, method)
                    heapq.heappush(open_set, (f_score[neighbor], neighbor))
    return []


def bfs(grid, start, goal):
    rows, cols = grid.shape
    queue = deque([start])
    came_from = {start: None}

    while queue:
        current = queue.popleft()
        if current == goal:
            path = []
            while current in came_from:
                path.append(current)
                current = came_from[current]
            return path[::-1]

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            neighbor = (current[0] + dx, current[1] + dy)
            if 0 <= neighbor[0] < rows and 0 <= neighbor[1] < cols and grid[
                neighbor] == 0 and neighbor not in came_from:
                came_from[neighbor] = current
                queue.append(neighbor)
    return []


def plot_path(grid, path, start, goal):
    plt.figure(figsize=(8, 8))
    plt.imshow(grid, cmap='gray_r')

    if path:
        path_x, path_y = zip(*path)
        plt.plot(path_y, path_x, marker='o', color='red', markersize=5, linewidth=2, label='Path')

    plt.scatter(start[1], start[0], color='green', s=100, label='Start')
    plt.scatter(goal[1], goal[0], color='blue', s=100, label='Goal')
    plt.legend()
    plt.grid(True)
    plt.show()


# Example usage
grid = np.zeros((10, 10))
grid[3, 3:7] = 1  # Adding obstacles
start, goal = (0, 0), (9, 9)

path_a_star_manhattan = astar(grid, start, goal, 'manhattan')
path_a_star_euclidean = astar(grid, start, goal, 'euclidean')
path_bfs = bfs(grid, start, goal)

plot_path(grid, path_a_star_manhattan, start, goal)
