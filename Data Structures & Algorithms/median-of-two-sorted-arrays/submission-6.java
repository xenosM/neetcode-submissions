class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always work on smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int l = 0, r = nums1.length - 1;
        //index for right most value of left partition for both the arrays
        int i, j;
        int total = nums1.length + nums2.length;
        int half = total / 2; // size of each partition of array
        while (true) {
            i = Math.floorDiv((l + r), 2); //Java division ceils negative division
            j = half - i - 2; //because half is a count of element needed but for indexes we need to be offset by one, so i and j both need to be offset by 1, which comes to 2

            /*
            -> If no element of an array is in the left partition then its index for  partition will be negative, then it can be assumed that the value is very small, so that later on in the caculation for max and min the other array will always win
            -> Similarily if no element of an array is in the right partition then its index for partion will exceed the array's length
            */

            // highest left partition and lowest right partition value of each array
            int l1Val = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int r1Val = i+1 < nums1.length ? nums1[i + 1] : Integer.MAX_VALUE;

            int l2Val = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            int r2Val = j+1  < nums2.length ? nums2[j + 1] : Integer.MAX_VALUE;

            //Check if the partition is valid
            if(l1Val <= r2Val && l2Val <= r1Val){
                if(total%2==0){
                    return (float)(Math.max(l1Val,l2Val)+Math.min(r1Val,r2Val))/2.0;
                }else{
                    return (float)Math.min(r1Val,r2Val);
                }
            }
            else if(l1Val >r2Val){
                r=i-1;
            }
            else{
                l=i+1;
            }
            
        }
    }
}
