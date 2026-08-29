class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervalList = new ArrayList<>();
        boolean insertFlag = true;

        for (int i = 0; i < intervals.length; i++) {
            if (insertFlag && intervals[i][0] >= newInterval[0]) {
                newIntervalList.add(new int[] { newInterval[0], newInterval[1] });
                insertFlag = false;
            }
            newIntervalList.add(new int[] { intervals[i][0], intervals[i][1] });
        }
        if(insertFlag){
            newIntervalList.add(new int[] { newInterval[0], newInterval[1] });
        }

        return mergeInterval(newIntervalList.toArray(new int[0][]));

    }

    public int[][] mergeInterval(int[][] newIntervals) {
        int start1 = newIntervals[0][0];
        int end1 = newIntervals[0][1];
        List<int[]> finalList = new ArrayList<>();

        for (int i = 1; i < newIntervals.length; i++) {
            int start2 = newIntervals[i][0];
            int end2 = newIntervals[i][1];

            if (end1 >= start2) {
                start1 = Math.min(start1, start2);
                end1 = Math.max(end1, end2);

                continue;
            }
            finalList.add(new int[] { start1, end1 });
            start1 = start2;
            end1 = end2;

        }
        finalList.add(new int[] { start1, end1 });
        return finalList.toArray(new int[0][]);
    }
}