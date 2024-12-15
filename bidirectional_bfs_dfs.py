import networkx as nx
import matplotlib.pyplot as plt
from collections import deque


# 1. Build a City Map (Graph)
def create_city_map():
    G = nx.Graph()
    # Adding intersections (nodes)
    G.add_edges_from([
        ('A', 'B'), ('A', 'C'), ('B', 'D'), ('C', 'D'),
        ('D', 'E'), ('E', 'F'), ('F', 'G'), ('D', 'G'),
        ('B', 'C'), ('E', 'G'), ('C', 'F')
    ])
    return G


# 2. Standard BFS to find shortest path
def bfs(G, start, goal):
    visited = set()
    parent = {}
    queue = deque([start])
    visited.add(start)
    while queue:
        node = queue.popleft()
        if node == goal:
            path = []
            while node in parent:
                path.append(node)
                node = parent[node]
            path.append(start)
            return path[::-1], visited
        for neighbor in G.neighbors(node):
            if neighbor not in visited:
                visited.add(neighbor)
                parent[neighbor] = node
                queue.append(neighbor)
    return None, visited  # No path found


# 3. Standard DFS to find shortest path (if exists)
def dfs(G, start, goal, visited=None, parent=None):
    if visited is None:
        visited = set()
    if parent is None:
        parent = {}

    visited.add(start)
    if start == goal:
        path = []
        while start in parent:
            path.append(start)
            start = parent[start]
        path.append(goal)
        return path[::-1], visited

    for neighbor in G.neighbors(start):
        if neighbor not in visited:
            parent[neighbor] = start
            result = dfs(G, neighbor, goal, visited, parent)
            if result:
                return result
    return None, visited  # No path found


# 4. Bidirectional BFS to find the shortest path
def bidirectional_bfs(G, start, goal):
    if start == goal:
        return [start], set([start])

    # Initialize
    visited_start = {start}
    visited_goal = {goal}
    parent_start = {start: None}
    parent_goal = {goal: None}
    queue_start = deque([start])
    queue_goal = deque([goal])

    while queue_start and queue_goal:
        # Expand from start side
        path_start, visited_start, parent_start = _expand_bfs(G, queue_start, visited_start, parent_start, 'start')
        if path_start: return path_start, visited_start

        # Expand from goal side
        path_goal, visited_goal, parent_goal = _expand_bfs(G, queue_goal, visited_goal, parent_goal, 'goal')
        if path_goal: return path_goal, visited_goal

    return None, visited_start  # No path found


# Helper function for bidirectional BFS expansion
def _expand_bfs(G, queue, visited, parent, side):
    node = queue.popleft()
    for neighbor in G.neighbors(node):
        if side == 'start' and neighbor not in visited:
            visited.add(neighbor)
            parent[neighbor] = node
            queue.append(neighbor)
        elif side == 'goal' and neighbor not in visited:
            visited.add(neighbor)
            parent[neighbor] = node
            queue.append(neighbor)
        # Check if paths meet
        if neighbor in visited:
            # Reconstruct the path
            path_start = []
            current = node
            while current is not None:
                path_start.append(current)
                current = parent.get(current, None)
            path_goal = []
            current = node
            while current is not None:
                path_goal.append(current)
                current = parent.get(current, None)
            return path_start + path_goal, visited
    return None, visited, parent


# 5. Visualization of the Graph and the Search Process
def visualize_search(G, path=None, search_nodes=None):
    pos = nx.spring_layout(G)
    plt.figure(figsize=(10, 8))

    # Draw the full graph
    nx.draw(G, pos, with_labels=True, node_size=700, node_color='skyblue', font_size=12)

    # Highlight the search nodes
    if search_nodes:
        search_nodes = set(search_nodes)
        search_subgraph = G.subgraph(search_nodes)
        nx.draw(search_subgraph, pos, with_labels=True, node_size=700, node_color='orange', font_size=12)

    # Highlight the path
    if path:
        edges = [(path[i], path[i + 1]) for i in range(len(path) - 1)]
        nx.draw_networkx_edges(G, pos, edgelist=edges, edge_color='red', width=3)

    plt.title('City Map Search Visualization')
    plt.show()


# 6. Main Execution and Comparison of Algorithms
def compare_algorithms():
    G = create_city_map()
    start, goal = 'A', 'G'

    # Perform BFS
    path_bfs, search_bfs = bfs(G, start, goal)
    print("BFS Path:", path_bfs)
    visualize_search(G, path=path_bfs, search_nodes=search_bfs)

    # Perform DFS
    path_dfs, search_dfs = dfs(G, start, goal)
    print("DFS Path:", path_dfs)
    visualize_search(G, path=path_dfs, search_nodes=search_dfs)

    # Perform Bidirectional BFS
    path_bidir, search_bidir = bidirectional_bfs(G, start, goal)
    print("Bidirectional BFS Path:", path_bidir)
    visualize_search(G, path=path_bidir, search_nodes=search_bidir)


# Run the comparison
compare_algorithms()
