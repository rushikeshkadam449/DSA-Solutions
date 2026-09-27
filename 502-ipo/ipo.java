class Project {
    int prof;
    int cap;

    public Project(int p, int c) {
        prof = p;
        cap = c;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < profits.length; i++) {
            Project ps = new Project(profits[i], capital[i]);
            //  project.prof = profits[i];
            //  project.cap = capital[i];
            projects.add(ps);
        }

        //  Collections.sort((a,b) -> (a.cap - b.cap));
        Collections.sort(projects, (a, b) -> Integer.compare(a.cap, b.cap));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while (k > 0) {
            while (idx < projects.size()) {
                if (projects.get(idx).cap > w) {
                    break;
                }
                pq.offer(projects.get(idx).prof);
                idx++;
            }
            if (pq.isEmpty()) {
                return w;
            }
            w += pq.poll();
            k--;
        }
        return w;
    }
}