class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize in-degree array
        int[] inDegree = new int[n];
        
        // Step 2: Compute in-degrees
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
        }
        
        // Step 3: Find nodes with zero in-degree
        List<Integer> zeroInDegreeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                zeroInDegreeNodes.add(i);
            }
        }
        
        // Step 4: Determine the result
        if (zeroInDegreeNodes.size() == 1) {
            return zeroInDegreeNodes.get(0); // Unique champion
        }
        return -1; // No champion or multiple possible champions
    }
}