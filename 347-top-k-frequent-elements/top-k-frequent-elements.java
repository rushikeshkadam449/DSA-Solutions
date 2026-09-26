class Pair {
    int num;
    int freq; 

    public Pair(int n, int f){
        num = n;
        freq = f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            ((a, b) -> a.freq - b.freq)
        );
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if(pq.size() < k){
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
                continue;
            }

             pq.offer(new Pair(entry.getKey(), entry.getValue()));
             pq.poll();
        }

        int [] res = new int[k];
        int i = 0;
        while(! pq.isEmpty()){
            res[i] = pq.poll().num;
            i++;
        }
        return res;

    }
}