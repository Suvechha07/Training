import java.util.Scanner;

public class FloydWarshallAlgorithm {

    final static int INF = 99999; // Use a large value to represent infinity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Number of Vertices: ");
        int n = scanner.nextInt();

        // Input adjacency matrix
        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix (use " + INF + " to represent infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Initialize distance and path matrices
        int[][] distance = new int[n][n];
        int[][] path = new int[n][n];
        initializeMatrices(graph, distance, path, n);

        // Apply Floyd-Warshall Algorithm
        floydWarshall(distance, path, n);

        // Display the shortest path distance matrix
        System.out.println("Shortest path weight matrix:");
        printMatrix(distance, n);

        // Input source and destination vertices
        System.out.print("Enter the source and destination vertex: ");
        int src = scanner.nextInt() - 1;
        int dest = scanner.nextInt() - 1;

        // Display the shortest path and path weight
        System.out.print("Shortest Path from vertex " + (src + 1) + " to vertex " + (dest + 1) + ": ");
        if (distance[src][dest] == INF) {
            System.out.println("No path exists");
        } else {
            printPath(path, src, dest);
            System.out.println("\nPath weight: " + distance[src][dest]);
        }
    }

    // Initialize distance and path matrices
    private static void initializeMatrices(int[][] graph, int[][] distance, int[][] path, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0 && i != j) {
                    distance[i][j] = INF;
                    path[i][j] = -1;
                } else {
                    distance[i][j] = graph[i][j];
                    path[i][j] = (graph[i][j] != INF && i != j) ? i : -1;
                }
            }
        }
    }

    // Floyd-Warshall algorithm to compute shortest paths
    private static void floydWarshall(int[][] distance, int[][] path, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }

    // Print matrix utility
    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // Print path utility - reconstructs path from path matrix
    private static void printPath(int[][] path, int src, int dest) {
        if (src == dest) {
            System.out.print((src + 1));
        } else if (path[src][dest] == -1) {
            System.out.print("No path exists");
        } else {
            printPath(path, src, path[src][dest]);
            System.out.print("-->" + (dest + 1));
        }
    }
}
