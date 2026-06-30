class Solution {
    public int maxSum(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        if (mx <= 0) return mx;  // all non-positive case
        
        boolean[] seen = new boolean[201]; // values range -100..100
        int ans = 0;
        for (int x : nums) {
            if (x < 0 || seen[x + 100]) continue; // skip negatives & duplicates
            ans += x;
            seen[x + 100] = true;
        }
        return ans;
    }
}
