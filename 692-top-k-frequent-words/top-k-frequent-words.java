class Pair {
    String word;
    int freq;

    public Pair(String w, int f) {
        word = w;
        freq = f;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) {
                        return a.freq - b.freq;
                    }
                    return b.word.compareTo(a.word);
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
                continue;
            }

            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            pq.poll();
        }

        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }

        Collections.reverse(res);

        return res;

    }
}