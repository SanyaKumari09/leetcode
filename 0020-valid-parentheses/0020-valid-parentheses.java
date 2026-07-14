class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                // if stack is empty, invalid
                if (st.isEmpty()) return false;

                char top = st.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // valid only if stack is empty
        return st.isEmpty();
    }
}
