class Solution {
    public int primePalindrome(int n) {
        // Special case: 11 is the only even-length prime palindrome
        if (n >= 8 && n <= 11) {
            return 11;
        }
        
        while (true) {
            if (n == reverse(n) && isPrime(n)) {
                return n;
            }
            n++;
            
            // Mathematical Optimization:
            // All palindromes with an even number of digits are divisible by 11.
            // Since 11 is already handled, we can completely skip even-length digit ranges.
            if (1_000 < n && n < 10_000) {
                n = 10_000; // Skip 4-digit numbers
            } else if (100_000 < n && n < 1_000_000) {
                n = 1_000_000; // Skip 6-digit numbers
            } else if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000; // Skip 8-digit numbers
            }
        }
    }
    
    // Helper function to reverse an integer
    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    
    // Helper function to check if a number is prime
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
