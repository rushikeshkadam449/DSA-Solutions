class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        int res = 0;
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }

        int left = 1;
        int right = maxPile;

        while (left <= right) {
            int speed = left + (right - left) / 2;

            if (isValid(piles, h, speed)) {
                res = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }
        return res;
    }

    public boolean isValid(int[] piles, int h, int speed) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % speed == 0) {
                hours = hours + piles[i] / speed;
            } else {
                hours = hours + piles[i] / speed + 1;
            }
        }

        return hours <= h;
    }
}