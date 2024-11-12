import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KruskalAlgorithm {
    static int[] parent;  // Parent array for union-find

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Input number of vertices (n) and edges (m)
        System.out.print("Enter number of vertices and edges (space-separated): ");
        String[] input = reader.readLine().split(" ");
        int vertices = Integer.parseInt(input[0]);
        int edges = Integer.parseInt(input[1]);

        // Store all edges as {u, v, w}
        int[][] graph = new int[edges][3];

        System.out.println("Enter the edges (u, v, w): ");
        for (int i = 0; i < edges; i++) {
            String[] edge = reader.readLine().split(" ");
            graph[i][0] = Integer.parseInt(edge[0]) - 1; // u (converted to 0-based)
            graph[i][1] = Integer.parseInt(edge[1]) - 1; // v (converted to 0-based)
            graph[i][2] = Integer.parseInt(edge[2]);     // w
        }

        // Initialize parent array for union-find
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        // Apply Kruskal's algorithm
        kruskalMST(graph, vertices, edges);
    }

    // Kruskal's algorithm to find the MST
    private static void kruskalMST(int[][] graph, int vertices, int edges) {
        // Sort the edges by weight using simple bubble sort (since we can't use util package)
        for (int i = 0; i < edges - 1; i++) {
            for (int j = 0; j < edges - i - 1; j++) {
                if (graph[j][2] > graph[j + 1][2]) {
                    // Swap the edges
                    int[] temp = graph[j];
                    graph[j] = graph[j + 1];
                    graph[j + 1] = temp;
                }
            }
        }

        System.out.println("Edge\t\tCost");
        int totalWeight = 0;
        int edgeCount = 0;

        // Go through the sorted edges and apply union-find
        for (int i = 0; i < edges; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int weight = graph[i][2];

            // Check if the current edge forms a cycle
            if (find(u) != find(v)) {
                // Union the sets
                union(u, v);

                // Select this edge for the MST
                System.out.println((u + 1) + "--" + (v + 1) + "\t\t" + weight);  // Output as 1-based
                totalWeight += weight;
                edgeCount++;

                // Stop if we have enough edges for the MST (V - 1 edges)
                if (edgeCount == vertices - 1) {
                    break;
                }
            }
        }

        // Output the total weight of the MST
        System.out.println("Total Weight of the Spanning Tree: " + totalWeight);
    }

    // Find the set of an element using path compression
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union of two sets
    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        parent[xRoot] = yRoot;
    }
}
