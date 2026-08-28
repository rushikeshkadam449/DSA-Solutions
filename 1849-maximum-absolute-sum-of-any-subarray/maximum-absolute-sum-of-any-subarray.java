class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int answer = Math.abs(nums[0]);
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int v1 = nums[i];
            int v2 = maxSum + nums[i];
            int v3 = minSum + nums[i];

            maxSum = Math.max(v1, v2);
            minSum = Math.min(v1, v3);
            answer = Math.max(answer, Math.max(maxSum, Math.abs(minSum)));

        }
        return answer;
    }
}