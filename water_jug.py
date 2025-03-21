# implement water jug problem for 3 jugs each with capacity 8l,5l,and 3l there is no
# measuring instrument available to measure the water in the jug as in initial state
# first jug is filled up with water from some external source whereas second jug and
# third jug are maintained empty but in the final stage first and second jug should
# contain 4l of water in each.
from collections import deque


def is_valid(state, capacities):
    return all(0 <= state[i] <= capacities[i] for i in range(3))


def get_next_states(state, capacities):
    next_states = []

    for i in range(3):
        for j in range(3):
            if i != j and state[i] > 0 and state[j] < capacities[j]:
                new_state = list(state)
                pour_amount = min(state[i], capacities[j] - state[j])
                new_state[i] -= pour_amount
                new_state[j] += pour_amount
                next_states.append(tuple(new_state))

    return next_states


def bfs_water_jug(capacities, initial_state, goal_state):
    queue = deque([initial_state])
    visited = set()
    parent = {initial_state: None}

    while queue:
        current_state = queue.popleft()

        if current_state == goal_state:
            path = []
            while current_state:
                path.append(current_state)
                current_state = parent[current_state]
            return path[::-1]  # Return reversed path

        visited.add(current_state)

        for next_state in get_next_states(current_state, capacities):
            if next_state not in visited and next_state not in parent:
                queue.append(next_state)
                parent[next_state] = current_state

    return None  # No solution found


if __name__ == "__main__":
    capacities = tuple(map(int, input("Enter the capacities of the three jugs (space-separated): ").split()))
    initial_state = tuple(map(int, input("Enter the initial state of the jugs (space-separated): ").split()))
    goal_state = tuple(map(int, input("Enter the goal state of the jugs (space-separated): ").split()))

    solution = bfs_water_jug(capacities, initial_state, goal_state)
    if solution:
        for step in solution:
            print(step)
    else:
        print("No solution found.")





# Enter the capacities of the three jugs (space-separated): 8 5 3
# Enter the initial state of the jugs (space-separated): 8 0 0
# Enter the goal state of the jugs (space-separated): 4 4 0