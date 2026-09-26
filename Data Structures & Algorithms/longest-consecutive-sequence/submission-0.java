class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int result = 0;
        for(int num: nums){
            int count = 0;
            if(numSet.contains(num-1)) continue;
            else{
                int startNum = num;
                while(numSet.contains(startNum++))count++;
            }
            result = count>result? count:result;
        }
        return result;
    }
}
