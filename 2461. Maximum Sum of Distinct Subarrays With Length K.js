function maximumSubarraySum(nums, k) {
    const seen = new Set();
    let start = 0;
    let currentSum = 0;
    let maxSum = 0;

    for (let end = 0; end < nums.length; end++) {
        // Add the current element to the sum
        currentSum += nums[end];
        
        // Ensure all elements in the subarray are distinct
        while (seen.has(nums[end])) {
            seen.delete(nums[start]);
            currentSum -= nums[start];
            start++;
        }

        // Add the current element to the set
        seen.add(nums[end]);

        // Check if the window size is equal to k
        if (end - start + 1 === k) {
            maxSum = Math.max(maxSum, currentSum);

            // Slide the window forward
            seen.delete(nums[start]);
            currentSum -= nums[start];
            start++;
        }
    }

    return maxSum;
}

