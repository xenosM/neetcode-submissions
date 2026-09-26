class Solution {
    public int search(int[] nums, int target) {
        int l=0,r= nums.length -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target ){
                return mid;
            }
            //check for left portion 
            if(nums[l] <= nums[mid]){
                if(target< nums[l] || target > nums[mid]){
                    //if target is not inside this range 
                    //reduce to right portion
                    l = mid+1;
                }
                else{
                //target is inside the range
                //reduce to left portion
                    r= mid-1;
                }
            }
            else{
                //mid value is in the right portion
                if(target>nums[r] || target < nums[mid]){
                    //target is outside the range
                    //reduce to left portion
                    r = mid -1;
                }
                else{
                    //target is in the range
                    //reduce to right portion
                    l = mid +1;
                }
            }
        }
        return -1;
    }
}
