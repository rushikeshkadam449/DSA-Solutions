class Pair {
    int index;
    int square;

    public Pair(int i, int s) {
        index = i;
        square = s;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.square != b.square) {
                        return b.square - a.square;
                    }
                    return b.index - a.index;
                });

        for (int i = 0; i < points.length; i++) {
            int sum = 0;
            sum += points[i][0] * points[i][0] + points[i][1] * points[i][1];

            if (pq.size() < k) {
                pq.offer(new Pair(i, sum));
                continue;
            }
            pq.offer(new Pair(i, sum));
            pq.poll();

        }

        int[][] res = new int[k][2];
        int a = 0;
        while (!pq.isEmpty()) {
            int idx = pq.poll().index;
            res[a][0] = points[idx][0];
            res[a][1] = points[idx][1];
            a++;
        }

        return res;
    }
}