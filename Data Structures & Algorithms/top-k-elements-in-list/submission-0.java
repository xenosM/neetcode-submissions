class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> seenCount = new HashMap<>();

        int[] result = new int[k];

        for(int num : nums){
            seenCount.put(num, seenCount.getOrDefault(num,0)+1);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(seenCount.keySet());
        keys.sort((a,b)-> seenCount.get(b) - seenCount.get(a));


        for(int i=0; i<k ; i++){
            result[i] = keys.get(i);
        }
        return result;
    }
}
