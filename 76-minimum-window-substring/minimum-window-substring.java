class Solution {
    public boolean isIncluded(Map<Character, Integer> have, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (!have.containsKey(entry.getKey()) || have.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        String result = "";
        int left = 0;

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char cha = s.charAt(right);

            have.put(cha, have.getOrDefault(cha, 0) + 1);

            while (isIncluded(have, need)) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                have.put(s.charAt(left), have.get(s.charAt(left)) - 1);

                if (have.get(s.charAt(left)) == 0) {
                    have.remove(s.charAt(left));
                }
                left++;

            }
        }
        return result;

    }
}