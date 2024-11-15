// 1574. Shortest Subarray to be Removed to Make Array Sorted


//Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing. Return the length of the shortest subarray to remove. A subarray is a contiguous subsequence of the array.

class Solution {
  int findLengthOfShortestSubarray(List<int> arr) {
    int n = arr.length;
    int left = 0, right = n - 1;

    while (left + 1 < n && arr[left] <= arr[left + 1]) {
      left++;
    }
    if (left == n - 1) return 0;

    while (right > 0 && arr[right - 1] <= arr[right]) {
      right--;
    }

    int result = (n - left - 1) < right ? (n - left - 1) : right;

    class Solution {
  int findLengthOfShortestSubarray(List<int> arr) {
    int n = arr.length;
    int left = 0, right = n - 1;

    while (left + 1 < n && arr[left] <= arr[left + 1]) {
      left++;
    }
    if (left == n - 1) return 0;

    while (right > 0 && arr[right - 1] <= arr[right]) {
      right--;
    }

    int result = (n - left - 1) < right ? (n - left - 1) : right;

    int i = 0, j = right;
    while (i <= left && j < n) {
      if (arr[i] <= arr[j]) {
        result = (result < (j - i - 1)) ? result : (j - i - 1);
        i++;
      } else {
        j++;
      }
    }

    return result;
  }
}


    return result;
  }
}
