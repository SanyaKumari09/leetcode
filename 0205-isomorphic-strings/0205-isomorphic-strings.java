class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sToT = new int[256];
        int[] tToS = new int[256];
        java.util.Arrays.fill(sToT, -1);
        java.util.Arrays.fill(tToS, -1);

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b = t.charAt(i);

            if (sToT[a] == -1 && tToS[b] == -1) {
                sToT[a] = b;
                tToS[b] = a;
            } else if (sToT[a] != b || tToS[b] != a) {
                return false;
            }
        }
        return true;
    }
}
