/*2461. Maximum Sum of Distinct Subarrays With Length K
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.*/


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

