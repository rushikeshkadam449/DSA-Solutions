class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int res = -1;

        if(target <= nums[nums.length -1] ){
            while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid] > nums[nums.length -1]){
                    left = mid+1;
                }else{
                    if(nums[mid] == target){
                        return mid;
                    }else if(nums[mid] < target){
                        left = mid +1;
                    }else{
                        right = mid -1;
                    }
                }
            }
        }else{
             while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid] > nums[nums.length -1]){
                    if(nums[mid] == target){
                        return mid;
                    }else if(nums[mid] < target){
                        left = mid +1;
                    }else{
                        right = mid -1;
                    }
                }else{
                   right = mid-1;
                }
            }
        }
        return res;
    }
}