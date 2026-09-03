class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> have = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (have.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}