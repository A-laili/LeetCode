class Solution:
    def slidingPuzzle(self, board):
        # Flatten the board to a string
        start = ''.join(str(num) for row in board for num in row)
        target = "123450"
        moves = {
            0: [1, 3],
            1: [0, 2, 4],
            2: [1, 5],
            3: [0, 4],
            4: [1, 3, 5],
            5: [2, 4]
        }
        
        # BFS initialization with a list used as a queue
        queue = [(start, start.index('0'), 0)]  # (state, index of 0, steps)
        visited = set()
        visited.add(start)
        
        while queue:
            # Pop the first element of the queue
            state, zero_idx, steps = queue[0]
            queue = queue[1:]
            
            # Check if solved
            if state == target:
                return steps
            
            # Generate all possible moves
            for neighbor in moves[zero_idx]:
                new_state = list(state)
                new_state[zero_idx], new_state[neighbor] = new_state[neighbor], new_state[zero_idx]
                new_state = ''.join(new_state)
                
                if new_state not in visited:
                    visited.add(new_state)
                    queue.append((new_state, neighbor, steps + 1))
        
        return -1
