class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int zeroes = 0;
        int ones = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                ones++;
            }

            int diff = zeroes - ones;
            if (diff == 0) {
                int length = i + 1;
                res = Math.max(res, length);
                continue;
            }

            if (map.containsKey(diff)) {
                int length = i - map.get(diff);
                res = Math.max(res, length);
            }

            map.putIfAbsent(diff, i);

        }
        return res;
    }
}