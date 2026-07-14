class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList <Integer> result = new ArrayList<>();

        int freqS[] = new int[26];
        int freqP[] = new int[26];

        for(int i=0;i<p.length();i++){
            freqP[p.charAt(i)-'a']++;
        }

        int left=0;
        for(int right=0;right<s.length();right++){
            freqS[s.charAt(right)-'a']++;

            if((right-left+1) > p.length()){
                freqS[s.charAt(left)-'a']--;
                left++;
            }
            if((right - left + 1) == p.length() &&Arrays.equals(freqS,freqP)){
                result.add(left);
            }
        }
        return result;
    }
}