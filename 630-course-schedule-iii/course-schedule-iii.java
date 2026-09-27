class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a);

        int currentDay = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            currentDay += duration;

            pq.offer(duration);

            if (currentDay > lastDay) {
                currentDay -= pq.poll();
            }

        }
        return pq.size();

// Failed my approach
        // PriorityQueue<Pair> pq = new PriorityQueue<>(
        //         (a, b) -> {
        //              if(a.lastDay != b.lastDay){
        //                return a.lastDay - b.lastDay;
        //              }
        //              return a.duration - b.duration;
        //         });

        // for (int[] x : courses) {
        //     pq.offer(new Pair(x[0], x[1]));
        // }
        // int coursesCount = 0;
        // int currentDay = 0;
        // while (!pq.isEmpty()) {
        //     Pair p = pq.poll();
        //     if (p.duration + currentDay <= p.lastDay) {
        //         coursesCount++;
        //         currentDay += p.duration;
        //     }
        // }
        // return coursesCount;

    }
}