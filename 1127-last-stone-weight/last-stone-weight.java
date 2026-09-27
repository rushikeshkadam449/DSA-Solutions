class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> (b - a));

        for (int x : stones) {
            pq.offer(x);
        }
        int res = 0;

        while (!pq.isEmpty()) {
            int v1 = pq.poll();
            if (pq.isEmpty()) {
                return v1;
            }
            int v2 = pq.poll();
            int v3 = Math.abs(v1 - v2);

            if (v3 == 0) {
                continue;
            }

            pq.offer(v3);
        }
        return res;
    }
}