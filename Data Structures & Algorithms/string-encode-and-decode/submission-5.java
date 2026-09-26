class Solution {

    public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(String.format("%d#%s",str.length(),str));
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        int length=0;   
        while(i<str.length()){
            int j = i;

            //get length at index i 
            while(str.charAt(j) != '#') j++;
            length = Integer.parseInt(str.substring(i,j)); 
            
            //Get substring to add in the list
            int endOfWord =(j+length) +1;
            String word = str.substring(j+1, endOfWord);
            result.add(word);

            //increment index i
            i = endOfWord;
        }
        return result;
    }
}
