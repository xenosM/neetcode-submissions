class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character,Integer> s1Count = new HashMap<>();
        Map<Character,Integer> s2Count = new HashMap<>();
        
        //Populating both the hashmaps with alphabets
        for(char c='a';c<='z';c++){
            s1Count.put(c,0);
            s2Count.put(c,0);
        }
        //Count the number of characters in s1 and count number of characters in initial window in s2
        for(int i=0;i<s1.length();i++){
            s1Count.put(s1.charAt(i),s1Count.get(s1.charAt(i))+1);
            s2Count.put(s2.charAt(i),s2Count.get(s2.charAt(i))+1);
        }
        int l=0,matches=0;
        //Initial match count for the count hashmaps
        for(int i=0;i<26;i++){
            if(s1Count.get((char)('a'+i)) == s2Count.get((char)('a'+i))){
                matches++;
            }
        }
        for( int r= s1.length();r<s2.length();r++){

            if(matches ==26) return true;
            //update s2Count for [r] and [l-1]
            char sPrev = s2.charAt(l), sCur = s2.charAt(r);
            //At r
            s2Count.put(sCur,s2Count.get(sCur)+1);
            if(s1Count.get(sCur)==s2Count.get(sCur)){
                matches++;
            }else if(s1Count.get(sCur)+1 == s2Count.get(sCur)){
                matches--;
            }
            //At l
            s2Count.put(sPrev,s2Count.get(sPrev)-1);
            if(s1Count.get(sPrev)==s2Count.get(sPrev)){
                matches++;
            }else if(s1Count.get(sPrev)-1 == s2Count.get(sPrev)){ // matches only changes when the count were the same before but during the current iteration it changed
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
