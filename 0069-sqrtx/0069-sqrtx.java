class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // sqrt(0)=0, sqrt(1)=1

        int left = 1, right = x / 2;  // sqrt(x) ≤ x/2 for x ≥ 2
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;  // use long to avoid overflow

            if (sq == x) {
                return mid;  // perfect square
            } else if (sq < x) {
                ans = mid;   // candidate answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
