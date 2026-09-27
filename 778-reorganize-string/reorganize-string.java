class Pair {
    char str;
    int freq;

    public Pair(char s, int f) {
        str = s;
        freq = f;
    }
}

class Solution {
    public String reorganizeString(String s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    return b.freq - a.freq;
                });

        PriorityQueue<Pair> pq1 = new PriorityQueue<>(
                (a, b) -> {
                    return b.freq - a.freq;
                });

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (idx == 0 || p.str != sb.charAt(idx - 1)) {
                sb.append(String.valueOf(p.str));
                idx++;

                if (p.freq > 1) {
                    pq.offer(new Pair(p.str, p.freq - 1));
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                Pair p1 = pq.poll();
                sb.append(String.valueOf(p1.str));
                idx++;

                if (p1.freq > 1) {
                    pq.offer(new Pair(p1.str, p1.freq - 1));
                }

                pq.offer(p);

            }
        }

        return sb.toString();

    }
}