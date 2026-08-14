class Solution {
    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {

                if (!st.isEmpty()) {
                    st.pop();
                }

            } else {

                st.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}