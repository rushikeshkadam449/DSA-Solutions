class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = firstList.length;
        int j = secondList.length;
        int a = 0;
        int b = 0;

        while(a < i && b < j) {
            int start1 = firstList[a][0];
            int end1 = firstList[a][1];

            int start2 = secondList[b][0];
            int end2 = secondList[b][1];

            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);
            
            if(start <= end){
                res.add(new int[]{start, end});
            }
            if(end1 < end2){
                a++;
            }else{
                b++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}