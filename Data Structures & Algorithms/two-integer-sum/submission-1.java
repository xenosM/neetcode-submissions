class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seenNumber = new HashMap<>();

        for(int i=0; i<nums.length;i++){
            int difference = target -nums[i];
            if(seenNumber.containsKey(difference)){
                return new int[]{seenNumber.get(difference),i};
            }
            seenNumber.put(nums[i],i);
        }
        return new int[]{};
    }
}
