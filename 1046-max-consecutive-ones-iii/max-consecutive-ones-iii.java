class Solution {
    public int longestOnes(int[] nums, int k) {
      //  Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        int zeroes = 0;

        for (int right = 0; right < nums.length; right++) {

            if(nums[right] == 0){
                zeroes++;
            }
            int currentWindow = right - left + 1;

            while(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            res = Math.max(res, right - left +1);
           // map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // int currentWindow = right - left + 1;

            // while (currentWindow - map.getOrDefault(1, 0) > k) {
            //     map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
            //     left++;
            //     currentWindow = right - left + 1;
            // }

          //  res = Math.max(res, right - left + 1);
        }
        return res;

    }
}