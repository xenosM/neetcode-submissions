class Solution {
    public boolean isPalindrome(String s) {
        int leftPtr = 0;
        int rightPtr = s.length() - 1; // ✅ starts at last index, not length

        // ✅ outer while is now the ONLY guard needed
        while (leftPtr < rightPtr) {

            // ✅ skip one non-alphanumeric from left then re-check outer condition
            if (!Character.isLetterOrDigit(s.charAt(leftPtr))) {
                leftPtr++;
                continue; // jumps back to while(leftPtr < rightPtr) ← re-validates
            }

            // ✅ skip one non-alphanumeric from right then re-check outer condition
            if (!Character.isLetterOrDigit(s.charAt(rightPtr))) {
                rightPtr--;
                continue; // jumps back to while(leftPtr < rightPtr) ← re-validates
            }

            // ✅ only reaches here if BOTH pointers are on alphanumeric characters
            if (Character.toLowerCase(s.charAt(leftPtr)) !=
                Character.toLowerCase(s.charAt(rightPtr))) return false;

            leftPtr++;
            rightPtr--;
        }
        return true;
    }
}