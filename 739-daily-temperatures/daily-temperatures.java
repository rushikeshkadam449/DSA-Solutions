class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length - 1);
        int [] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;

        for(int i = temperatures.length -2; i >= 0; i--) {

            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i;
            }

            stack.push(i); 
        }
        return res;
    }
}