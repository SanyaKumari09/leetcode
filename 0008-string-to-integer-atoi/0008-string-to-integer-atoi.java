class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;
        
        // Step 2: Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Parse digits
        int ans = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            
            // Step 4: Check overflow BEFORE updating
            if (ans > Integer.MAX_VALUE / 10 || 
               (ans == Integer.MAX_VALUE / 10 && d > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            ans = ans * 10 + d;
            i++;
        }
        
        return ans * sign;
    }
}
