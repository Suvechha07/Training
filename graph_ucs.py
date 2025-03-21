import heapq
import networkx as nx
import matplotlib.pyplot as plt


def uniform_cost_search(graph, start, goal):
    """
    Perform Uniform Cost Search on a weighted graph.

    :param graph: Dictionary representing the graph as an adjacency list
    :param start: Starting node
    :param goal: Goal node
    :return: Tuple containing the optimal path and its cost
    """
    priority_queue = []
    heapq.heappush(priority_queue, (0, start))  # (cost, node)

    cost_so_far = {start: 0}
    came_from = {start: None}

    while priority_queue:
        current_cost, current_node = heapq.heappop(priority_queue)

        if current_node == goal:
            path = []
            while current_node:
                path.append(current_node)
                current_node = came_from[current_node]
            return path[::-1], current_cost

        for neighbor, weight in graph.get(current_node, []):
            new_cost = current_cost + weight
            if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:
                cost_so_far[neighbor] = new_cost
                heapq.heappush(priority_queue, (new_cost, neighbor))
                came_from[neighbor] = current_node

    return None, float('inf')  # No path found


def draw_graph(graph, path):
    """
    Draw the graph and highlight the optimal path.

    :param graph: Dictionary representing the graph as an adjacency list
    :param path: List of nodes representing the optimal path
    """
    G = nx.DiGraph()
    for node, neighbors in graph.items():
        for neighbor, weight in neighbors:
            G.add_edge(node, neighbor, weight=weight)

    pos = nx.spring_layout(G)  # Position nodes using spring layout

    # Draw all nodes and edges
    nx.draw(G, pos, with_labels=True, node_color="lightblue", node_size=3000, font_size=10)
    nx.draw_networkx_edge_labels(
        G, pos, edge_labels={(u, v): f"{d['weight']}" for u, v, d in G.edges(data=True)}, font_size=10
    )

    # Highlight the optimal path
    if path:
        path_edges = list(zip(path, path[1:]))
        nx.draw_networkx_edges(G, pos, edgelist=path_edges, edge_color="red", width=2)
        nx.draw_networkx_nodes(G, pos, nodelist=path, node_color="orange")

    plt.title("Graph with Optimal Path Highlighted")
    plt.show()


# Example graph as an adjacency list
graph = {
    'A': [('B', 1), ('C', 4)],
    'B': [('A', 1), ('D', 2), ('E', 5)],
    'C': [('A', 4), ('E', 1)],
    'D': [('B', 2), ('E', 3), ('F', 2)],
    'E': [('B', 5), ('C', 1), ('D', 3), ('F', 1)],
    'F': [('D', 2), ('E', 1)]
}

# Perform UCS
start_node = 'A'
goal_node = 'F'
path, cost = uniform_cost_search(graph, start_node, goal_node)

print("Optimal Path:", path)
print("Minimum Cost:", cost)

# Draw the graph and highlight the optimal path
draw_graph(graph, path)
