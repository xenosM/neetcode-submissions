class Solution {
    public int findMin(int[] nums) {
        int l=0, r= nums.length -1;
        int result = nums[0];
        while(l<=r){
            //If the array is normally sorted
            if(nums[l]<nums[r]){
                result = Math.min(result,nums[l]);
                break;
            }
            int mid = (l+r)/2;
            result = Math.min(result,nums[mid]);
            //if the mid is in the left portion
            if(nums[mid]>=nums[l]){
                l = mid +1;
            }
            else{
                r= mid -1;
            }
        }
        return result;
    }

}
