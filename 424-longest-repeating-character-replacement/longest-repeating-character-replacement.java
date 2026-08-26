class Solution {
    public int maxChar(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {

        int[] arr = new int[256];
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char cha = s.charAt(right);
            arr[cha - 'A']++;
            int diff = right - left + 1;
            int maxCount = maxChar(arr);

            while (diff - maxCount > k) {
                arr[s.charAt(left) - 'A']--;
                maxCount = maxChar(arr);
                left++;
                diff = right - left + 1;

            }

            res = Math.max(res, right - left + 1);

        }
        return res;
    }
}