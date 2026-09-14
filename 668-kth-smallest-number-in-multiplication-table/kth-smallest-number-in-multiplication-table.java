class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (smallElement(m, n, mid) <= k - 1) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public int smallElement(int m, int n, int mid) {
        int row = m;
        int col = 1;
        int count = 0;
        while (row >= 1 && col <= n) {
            if (row * col > mid) {
                row--;
            } else {
                count = count + row;
                col++;
            }
        }
        return count;
    }
}