class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left=0;
        int right=sb.length()-1;

        while(left<right){
            char chleft = sb.charAt(left);
            char chright = sb.charAt(right);
            if(!isVowel(chleft)){
                left++;
            }else if(!isVowel(chright)){
                right--;
            }else{
                char temp = s.charAt(left);
                sb.setCharAt(left, s.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
}