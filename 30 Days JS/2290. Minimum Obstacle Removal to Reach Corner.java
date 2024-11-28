/*
 * 2290. Minimum Obstacle Removal to Reach Corner
Hard
Topics
Companies
Hint
You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).
 */



public class MinimumObstacleRemoval {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        
        // Initialize cost matrix to a high value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = 0;

        // Custom deque implementation (use linked nodes)
        Deque deque = new Deque();
        deque.offerLast(new int[]{0, 0, 0}); // {cost, x, y}

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int c = current[0], x = current[1], y = current[2];

            if (x == m - 1 && y == n - 1) {
                return c; // Reached target
            }

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newCost = c + grid[nx][ny];
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (grid[nx][ny] == 0) {
                            deque.offerFirst(new int[]{newCost, nx, ny});
                        } else {
                            deque.offerLast(new int[]{newCost, nx, ny});
                        }
                    }
                }
            }
        }

        return -1; // No path found (should not happen in this problem)
    }

    // Simple deque implementation
    class Deque {
        Node head, tail;

        class Node {
            int[] data;
            Node next, prev;
            Node(int[] data) { this.data = data; }
        }

        void offerFirst(int[] data) {
            Node node = new Node(data);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        void offerLast(int[] data) {
            Node node = new Node(data);
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        int[] pollFirst() {
            if (head == null) return null;
            Node node = head;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return node.data;
        }

        boolean isEmpty() {
            return head == null;
        }
    }
}