class Solution {
    public boolean isPalindrome(String s) {
        int leftPtr = 0;
        int rightPtr = s.length(); 

        while(rightPtr > leftPtr){
            while(rightPtr > leftPtr && !Character.isLetterOrDigit(s.charAt(leftPtr))){
                leftPtr++;
            }
            while(rightPtr > leftPtr && !Character.isLetterOrDigit(s.charAt(rightPtr-1))){
                rightPtr--;
            }
            
            if (leftPtr < rightPtr) {
                if(Character.toLowerCase(s.charAt(rightPtr-1)) != Character.toLowerCase(s.charAt(leftPtr))) return false;
                leftPtr++;
                rightPtr--;
            }
        }
        return true;
    }
}