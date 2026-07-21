class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        long ans = factorial(primeCount) * factorial(n - primeCount);
        return (int)(ans % MOD);
    }

    private int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }

    private long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
}
