import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int r=0;
        int len=0;
        int maxLen=0;
        int hash[] = new int[256];
        Arrays.fill(hash, -1);
        while(r<n){
           if(hash[s.charAt(r)]!=-1){
              if(hash [s.charAt(r)] >= l ){
                l=hash[s.charAt(r)]+1;
              }
           }
           len=r-l+1;
           maxLen=Math.max(len,maxLen);
           hash[s.charAt(r)]=r;
           r++;
        }
        return maxLen;
    }
}