class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length -1;
        int res = 0;

        while(left <= right) {
          int mid = left + ( right - left) /2;
// mid >=  && mid < arr.length -1 && 
          if(arr[mid] > arr[mid + 1]){
            res = mid;
            right = mid -1;
           // left = mid +1;
          }else{
           // right = mid - 1;
           left = mid +1;
          }


        }
        return res;
    }
}