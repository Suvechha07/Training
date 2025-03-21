import heapq


def uniform_cost_search(graph, start, goal):
    """
    Perform Uniform Cost Search on a weighted graph.

    :param graph: Dictionary representing the graph as an adjacency list
    :param start: Starting node
    :param goal: Goal node
    :return: Tuple containing the optimal path and its cost
    """
    # Priority queue for the frontier
    priority_queue = []
    heapq.heappush(priority_queue, (0, start))  # (cost, node)

    # Store the minimum cost to reach each node
    cost_so_far = {start: 0}

    # Track the path
    came_from = {start: None}

    while priority_queue:
        current_cost, current_node = heapq.heappop(priority_queue)

        # If goal is reached, reconstruct the path
        if current_node == goal:
            path = []
            while current_node:
                path.append(current_node)
                current_node = came_from[current_node]
            return path[::-1], current_cost

        # Explore neighbors
        for neighbor, weight in graph.get(current_node, []):
            new_cost = current_cost + weight
            if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:
                cost_so_far[neighbor] = new_cost
                heapq.heappush(priority_queue, (new_cost, neighbor))
                came_from[neighbor] = current_node

    return None, float('inf')  # No path found


# Example graph as an adjacency list
graph = {
    'A': [('B', 1), ('C', 4)],
    'B': [('A', 1), ('D', 2), ('E', 5)],
    'C': [('A', 4), ('E', 1)],
    'D': [('B', 2), ('E', 3), ('F', 2)],
    'E': [('B', 5), ('C', 1), ('D', 3), ('F', 1)],
    'F': [('D', 2), ('E', 1)]
}

# Testing UCS
start_node = 'A'
goal_node = 'F'
path, cost = uniform_cost_search(graph, start_node, goal_node)
print("Optimal Path:", path)
print("Minimum Cost:", cost)
