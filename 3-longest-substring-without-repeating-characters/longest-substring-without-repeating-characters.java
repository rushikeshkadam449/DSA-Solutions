class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;

        for(int right = 0; right < s.length(); right++) {
            char cha = s.charAt(right);
            
            map.put(cha, map.getOrDefault(cha, 0) + 1);

            int diff = right - left + 1;

            while(map.size() < diff){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);

                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
                diff = right - left + 1;
            }

            if(map.size() == diff){
                res = Math.max(res, diff);
            }

        }
        return res;
    }
}