class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] answer = new int[2];
        int j = 0; 
        while (answer[0] == 0 && answer[1] == 0 ){
            j++; 
            for (int i=0; i<nums.length - j; i++){
                if (nums[i] + nums[i+j] == target){
                    answer[0] = i;
                    answer[1] = i+j;
                }
            }
        }
        return answer; 
    }
}
