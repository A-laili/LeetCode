public class Solution {

    // Method to compute the shortest path using BFS
    public int shortestPath(int n, int[][] graph) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = -1;  // Initialize distances as -1 (unvisited)
        }
        dist[0] = 0;  // Starting city (city 0) has distance 0
        
        // Use a simple queue simulation for BFS
        int[] queue = new int[n];
        int front = 0, rear = 0;
        queue[rear++] = 0;  // Enqueue city 0
        
        while (front < rear) {
            int node = queue[front++];
            
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[node][neighbor] == 1 && dist[neighbor] == -1) {  // If there's a road and it's unvisited
                    dist[neighbor] = dist[node] + 1;  // Set the distance for this neighbor
                    queue[rear++] = neighbor;  // Enqueue the neighbor
                }
            }
        }
        
        return dist[n - 1];  // Return the distance to city n-1 (the last city)
    }

    // Main method to process each query and compute the shortest path
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Step 1: Initialize the graph with default roads
        int[][] graph = new int[n][n]; // Adjacency matrix for the graph
        for (int i = 0; i < n - 1; i++) {
            graph[i][i + 1] = 1;  // Initial road i -> i+1 (distance 1)
        }

        // Step 2: Process each query and compute the shortest path after each addition
        int m = queries.length;
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            graph[u][v] = 1;  // Add the new road (u -> v)
            
            // After adding the road, compute the shortest path
            answer[i] = shortestPath(n, graph);
        }

        return answer;
    }}