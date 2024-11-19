//Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1. A subarray is a contiguous part of an array.


function shortestSubarray(nums, k) {
    const n = nums.length;
    const prefixSum = Array(n + 1).fill(0);
    
    // Calculate the prefix sum
    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    const deque = [];
    let minLength = Infinity;

    for (let i = 0; i <= n; i++) {
        // Check if the current subarray satisfies the condition
        while (deque.length > 0 && prefixSum[i] - prefixSum[deque[0]] >= k) {
            minLength = Math.min(minLength, i - deque.shift());
        }
        
        // Maintain increasing order in deque for the prefix sum
        while (deque.length > 0 && prefixSum[i] <= prefixSum[deque[deque.length - 1]]) {
            deque.pop();
        }

        deque.push(i);
    }

    return minLength === Infinity ? -1 : minLength;
}