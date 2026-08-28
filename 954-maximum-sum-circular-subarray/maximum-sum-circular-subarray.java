class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int minSum = nums[0];
        int maxEnding = nums[0];

        int maxSum = nums[0];
        int minEnding = nums[0];

        for(int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            int v1 = nums[i];
            int v2 = maxEnding + nums[i];
            int v3 = minEnding + nums[i];

            maxEnding = Math.max(v1, v2);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(v1,v3);
            minSum = Math.min(minSum, minEnding);

        }
        if(maxSum < 0){
            return maxSum;
        }

        return  Math.max(maxSum, totalSum - minSum);

        
    }
}