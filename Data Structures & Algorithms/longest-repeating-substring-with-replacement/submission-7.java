class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> countSet = new HashSet<>();
        int result=0;
        // ->Populate the Hashset with all the characters in the string 
        // ->This is to be used for keeping track of all the characters in the string
        // that we need to run a sliding window on
        for(char c: s.toCharArray()){ //!! we have to change the string into a char array
            countSet.add(c);
        }

        // ->For each char in the strin we will run a seperate sliding window to check if using that 
        // char we can create the longest string of repeating character using k replacement
        for(char c: countSet){
            int l=0,count=0;// The number of chosen char that is present in the window
            for(int r=0;r<s.length();r++){
                if(s.charAt(r) == c) count++;
                // ->If the number of replacement to be made is more than k then we strink the window 
                // until the  number of replacement is less than k
                while((r-l+1)-count>k){ // number of replacement to be made = (length of substring) - (number of chosen character)
                    if(s.charAt(l)==c) count--;// if the left-most char is the chosen char then we must reduce its count
                    l++;
                }
                result = Math.max(result,r-l+1);
            }

        }
        return result;
    }
}
