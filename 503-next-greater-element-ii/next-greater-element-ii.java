class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int [] res = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for(int i = nums.length -1; i >=0; i--) {
            while(! stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }

            stack.push(nums[i]);
        }
       
        return res;
    }
}