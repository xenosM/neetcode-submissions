class Solution {
    public String minWindow(String s, String t) {
        //1. Make two hash map, one will store the count of character in t and the other will store the count of character in the window
        //2. the windowCounter will only keep count of values that are in t only.
        //3. we will also keep a have and need variable, where have counts how many keys in windowCount have the same count as the corresponding key in tCount
        // 4. when have and need will be equal, we will save the substring as a potential answer
        //5. Then we will shift the l pointer until the the haveCounter has been changed(a character which is in t has been removed from the window), char count in window < count in tCount

        Map<Character,Integer> tCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();
        int l=0;
        int start=0,end=0,length=0; //starting & ending index of substring, length of substring

        //count the characters in t 
        for(char c: t.toCharArray()){
           tCount.put(c,tCount.getOrDefault(c,0)+1);
           windowCount.put(c,0);
        }
        int have=0,need = tCount.size();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            //if a char exists as a key in windowCount, its count will increase
            if(windowCount.containsKey(c)){
                windowCount.put(c,windowCount.get(c)+1);
                //after increasing the count, if the value of the key is same in both in count hash have is increased
                if(windowCount.get(c).intValue() == tCount.get(c).intValue()){
                    have++;
                }
            }
           
            while(have==need){// keep shifting l until dont have what we need
                //we need this inside the while loop because in each shrink where the condition is being fulfilled is a possible new valid substring
                int newLength = r-l+1;
                if(newLength <length || length == 0){// only updates when the new substring is the smallest
                    start =l;
                    end  =r;
                    length = newLength;
                }

                char lc= s.charAt(l);
                l++;
                //reducing the count if the key is in the windowCount
                if(windowCount.containsKey(lc)){
                    windowCount.put(lc,windowCount.get(lc)-1);
                    //decrementing have when the count for key in windowCount becomes less than that in tCount
                    if(windowCount.get(lc).intValue() < tCount.get(lc).intValue()){
                        have--;
                    }
                }
            }
        }
    return length ==0?"":s.substring(start,end+1);//end of substring is exclusive
    }
}
