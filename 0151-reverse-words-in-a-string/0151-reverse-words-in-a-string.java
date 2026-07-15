class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim and convert to char array
        char[] arr = s.trim().toCharArray();
        int n = arr.length;

        // Step 2: Reverse entire string
        reverse(arr, 0, n - 1);

        // Step 3: Reverse each word
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverse(arr, start, n - 1); // last word

        // Step 4: Collapse multiple spaces
        StringBuilder sb = new StringBuilder();
        boolean spaceFlag = false;
        for (char c : arr) {
            if (c == ' ') {
                if (!spaceFlag) { // only add one space
                    sb.append(c);
                    spaceFlag = true;
                }
            } else {
                sb.append(c);
                spaceFlag = false;
            }
        }

        return sb.toString();
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
