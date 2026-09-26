class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String> > map = new HashMap<>();

        for(String str: strs){
        int[] seenLetterCount  = new int[26];
            for(int i = 0;i<str.length() ; i++){
                seenLetterCount[(int) (str.charAt(i) -'a')]++;
            }
            String stringArray = Arrays.toString(seenLetterCount);
            if(!map.containsKey(stringArray)){
                map.put(stringArray,new ArrayList<>(Arrays.asList(str)));
            }
            else{
                map.get(stringArray).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
