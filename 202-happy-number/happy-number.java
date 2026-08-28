class Solution {
    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;

            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int sum = 0;
        int slow = n;
        int fast = n;
        while (n > 0) {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);

            if (slow == fast) {
                return slow == 1;
            }

        }

        return false;
    }
}