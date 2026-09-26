class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seenValues = new HashSet<>();
        int result = 0;
        int l=0;
        for(int r=0;r<s.length();r++){
            while(seenValues.contains(s.charAt(r))){
                seenValues.remove(s.charAt(l));
                l++;
            }
            seenValues.add(s.charAt(r));
            result = Math.max(result,r-l+1);
        }
        return result;
    }
}
