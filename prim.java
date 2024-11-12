import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class prim {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Input: Number of vertices
        System.out.print("Enter the Number of Vertices: ");
        int vertices = Integer.parseInt(reader.readLine());

        // Adjacency matrix
        int[][] graph = new int[vertices][vertices];

        // Input the graph adjacency matrix
        System.out.println("Enter the Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        // Input: Starting vertex (1-based index)
        System.out.print("Enter the Starting Vertex: ");
        int startVertex = Integer.parseInt(reader.readLine()) - 1; // Converting to 0-based

        // Prim's algorithm
        primMST(graph, vertices, startVertex);
    }

    // Function to find the minimum spanning tree and display the result
    private static void primMST(int[][] graph, int vertices, int startVertex) {
        boolean[] mstSet = new boolean[vertices];  // To track vertices included in MST
        int[] key = new int[vertices];             // Used to pick the minimum weight edge
        int[] parent = new int[vertices];          // Array to store the MST

        // Initialize all keys as infinity (except for the start vertex)
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1; // No parent yet
        }
        key[startVertex] = 0; // Starting vertex will be picked first

        // Find the MST for all vertices
        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet, vertices);  // Pick the minimum key vertex
            mstSet[u] = true;  // Add the vertex to the MST set

            // Update the key and parent index of adjacent vertices
            for (int v = 0; v < vertices; v++) {
                // Only consider the vertices not yet in MST and where there is an edge
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Display the cost adjacency matrix of the MST
        displayMST(graph, parent, vertices);
    }

    // Utility function to find the vertex with minimum key value
    private static int minKey(int[] key, boolean[] mstSet, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to display the Minimum Spanning Tree and total weight
    private static void displayMST(int[][] graph, int[] parent, int vertices) {
        int[][] mstGraph = new int[vertices][vertices];  // For the MST adjacency matrix
        int totalWeight = 0;

        for (int i = 1; i < vertices; i++) {
            int u = parent[i];
            int v = i;
            mstGraph[u][v] = graph[u][v];
            mstGraph[v][u] = graph[u][v];
            totalWeight += graph[u][v];
        }

        // Display the MST adjacency matrix
        System.out.println("Cost Adjacency Matrix of the Minimum Spanning Tree: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(mstGraph[i][j] + "\t");
            }
            System.out.println();
        }

        // Display the total weight of the MST
        System.out.println("Total Weight of the Spanning Tree: " + totalWeight);
    }
}
