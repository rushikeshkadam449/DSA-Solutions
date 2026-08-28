class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int v1 = maxProduct * nums[i];
            int v2 = nums[i];
            int v3 = minProduct * nums[i];

            maxProduct = Math.max(Math.max(v1, v2), v3);
            minProduct = Math.min(Math.min(v1, v2), v3);

            answer = Math.max(answer, Math.max(maxProduct, minProduct));
        }
        return answer;
    }
}