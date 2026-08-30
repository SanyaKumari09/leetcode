import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, i);

            int len = i - left + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}


// int n=s.length();
//         int l=0;
//         int r=0;
//         int len=0;
//         int maxLen=0;
//         int hash[] = new int[256];
//         Arrays.fill(hash, -1);
//         while(r<n){
//            if(hash[s.charAt(r)]!=-1){
//                 if(hash [s.charAt(r)] >= l ){
//                    l=hash[s.charAt(r)]+1;
//                 }
//            }
//            len=r-l+1;
//            maxLen=Math.max(len,maxLen);
//            hash[s.charAt(r)]=r;
//            r++;
//         }
//         return maxLen;