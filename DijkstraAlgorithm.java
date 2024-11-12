import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DijkstraAlgorithm 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        
        System.out.print("Enter the Number of Vertices: ");
        int vertices = Integer.parseInt(reader.readLine());

        int[][] graph = new int[vertices][vertices];
        
        System.out.println("Enter the Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++) 
        {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < vertices; j++) 
            {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.print("Enter the Source Vertex: ");
        int source = Integer.parseInt(reader.readLine()) - 1;  
        
        dijkstra(graph, source, vertices);
    }

    private static int findMinDistance(int[] distance, boolean[] visited, int vertices) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distance[v] < min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void displayShortestPaths(int[] distance, int[] parent, int vertices, int source) 
    {
        System.out.println("Source\tDestination\tCost\tPath");
        for (int i = 0; i < vertices; i++) 
        {
            System.out.print((source + 1) + "\t" + (i + 1) + "\t\t" + distance[i] + "\t");
            if (distance[i] == Integer.MAX_VALUE) 
            {
                System.out.println("-");
            }
            else 
            {
                printPath(i, parent);
                System.out.println();
            }
        }
    }

    private static void printPath(int currentVertex, int[] parent) 
    {
        if (parent[currentVertex] == -1) 
        {
            System.out.print(currentVertex + 1);
            return;
        }
        printPath(parent[currentVertex], parent);
        System.out.print("->" + (currentVertex + 1));
    }

    private static void dijkstra(int[][] graph, int source, int vertices) 
    {
        int[] distance = new int[vertices];  
        boolean[] visited = new boolean[vertices];  
        int[] parent = new int[vertices];  
        
        for (int i = 0; i < vertices; i++) 
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
        }

         distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) 
        {
            int u = findMinDistance(distance, visited, vertices);

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) 
                {
                    distance[v] = distance[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        displayShortestPaths(distance, parent, vertices, source);
    }
}
