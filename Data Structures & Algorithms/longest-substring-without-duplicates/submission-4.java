class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int result=0;
        Set<Character> seenValue = new HashSet<>(); //keep tracks of all the char that are in the window
        
        // The r pointer checks every char to  ensure it are not a duplicate
        for(;r<s.length();r++){
            //-> Loop is intiated when a duplicate character is found
            //-> Shrinks the window until the duplicate character is removed
            //-> The characters which are before the duplicate is also removed because a substring is always continuos and 
            // removing only the duplicate will create a break
            while(seenValue.contains(s.charAt(r))){
                //starts removing from the start of the substring as the duplicate char is invalid
                seenValue.remove(s.charAt(l));
                l++;
            }

            seenValue.add(s.charAt(r));
            result = Math.max(result,r-l+1);
        }

        return result;
    }
}
