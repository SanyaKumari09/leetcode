class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int g = gcd(targetX, targetY);
        // A power of 2 will only leave 1 after continuously dividing by 2
        while (g % 2 == 0) {
            g /= 2;
        }
        return g == 1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
