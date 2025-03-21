import random

# Function to evaluate fitness
def fitness(x):
    return - (x**2) / 10 + 3 * x

# Convert integer to binary string (5-bit representation)
def int_to_bin(x):
    return format(x, '05b')

# Convert binary string to integer
def bin_to_int(b):
    return int(b, 2)

# Generate initial population (random values in range 1 to 31)
population_size = 5
population = [random.randint(1, 31) for _ in range(population_size)]

# Evaluate fitness of initial population
fitness_values = [fitness(x) for x in population]

# Selection (Tournament Selection)
def tournament_selection(population, fitness_values):
    tournament_size = 2
    selected = random.sample(list(zip(population, fitness_values)), tournament_size)
    return max(selected, key=lambda x: x[1])[0]  # Return individual with highest fitness

# Crossover (Single-point crossover)
def crossover(parent1, parent2):
    p1_bin, p2_bin = int_to_bin(parent1), int_to_bin(parent2)
    point = random.randint(1, 4)  # Choose crossover point
    child1_bin = p1_bin[:point] + p2_bin[point:]
    child2_bin = p2_bin[:point] + p1_bin[point:]
    return bin_to_int(child1_bin), bin_to_int(child2_bin)

# Mutation (Bit-flip mutation)
def mutate(individual):
    bin_repr = int_to_bin(individual)
    index = random.randint(0, 4)  # Choose mutation point
    mutated_bin = (
        bin_repr[:index] + ('1' if bin_repr[index] == '0' else '0') + bin_repr[index + 1:]
    )
    return bin_to_int(mutated_bin)

# Perform one iteration of Genetic Algorithm
new_population = []

# Selection and Crossover
for _ in range(population_size // 2):  # Create new pairs
    parent1 = tournament_selection(population, fitness_values)
    parent2 = tournament_selection(population, fitness_values)
    child1, child2 = crossover(parent1, parent2)
    new_population.extend([child1, child2])

# Mutation
new_population = [mutate(ind) if random.random() < 0.1 else ind for ind in new_population]

# Evaluate new population
new_fitness_values = [fitness(x) for x in new_population]

# Print results
print("Initial Population:", population)
print("Initial Fitness:", fitness_values)
print("New Population after Crossover & Mutation:", new_population)
print("New Fitness:", new_fitness_values)
