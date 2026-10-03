class Solution {
    public int fib(int n) {
        return function(n);
    }

    public int function(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return function(n - 1) + function(n - 2);
    }
}