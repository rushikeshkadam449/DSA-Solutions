class Solution {
    public int maximumSum(int[] arr) {
        int answer = arr[0];
        int noDelete = arr[0];
        int withOneDelete = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int v1 = arr[i];
            int v2 = noDelete;
            int v3 = noDelete + arr[i];
            int v4;
            if (withOneDelete == Integer.MIN_VALUE) {
                v4 =  Math.max(v1,v2);
            }else{
                v4 = withOneDelete + arr[i];
            }

            noDelete = Math.max(v1, v3);
            withOneDelete = Math.max(v2, v4);

            answer = Math.max(answer, Math.max(noDelete, withOneDelete));

        }
        return answer;

    }
}