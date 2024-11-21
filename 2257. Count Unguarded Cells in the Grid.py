# You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

# A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

# Return the number of unoccupied cells that are not guarded.



from typing import List

class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        # Initialize the grid
        grid = [[0] * n for _ in range(m)]
        
        # Mark guards with 1 and walls with 2
        for r, c in guards:
            grid[r][c] = 1
        for r, c in walls:
            grid[r][c] = 2

        # Directions: north, east, south, west
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        # Mark guarded cells with -1
        for r, c in guards:
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                while 0 <= nr < m and 0 <= nc < n:
                    if grid[nr][nc] == 2 or grid[nr][nc] == 1:  # Stop at walls or guards
                        break
                    if grid[nr][nc] == 0:  # Mark as guarded
                        grid[nr][nc] = -1
                    nr += dr
                    nc += dc

        # Count unguarded cells
        unguarded_count = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 0:  # Unoccupied and not guarded
                    unguarded_count += 1

        return unguarded_count
