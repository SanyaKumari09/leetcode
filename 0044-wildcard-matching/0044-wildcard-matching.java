class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        prev[0] = true;

        for (int j = 1; j <= m; j++) {

            boolean allStar = true;

            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    allStar = false;
                    break;
                }
            }

            prev[j] = allStar;
        }

        for (int i = 1; i <= n; i++) {

            curr[0] = false;

            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {

                    curr[j] = prev[j - 1];

                } else if (p.charAt(j - 1) == '*') {

                    curr[j] = curr[j - 1] || prev[j];

                } else {

                    curr[j] = false;
                }
            }

            prev = curr.clone();
        }

        return prev[m];
    }
}