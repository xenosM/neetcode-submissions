class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int result = -1;
        // find the maximum possible value for k
        int max = piles[0]; 
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i]; 
            }
        }
        // range for possible value of k will be 1 to max.
        
        //binary search for the minimum possible value of k for the given h
        int l=1,r=max;// search range start at 1 to max
        while(l<=r){
            int mid = (l+r) /2;
            // check if the mid value will finish all the piles
            int sumHours=0;
            for(int i =0;i<piles.length;i++){
                //double because it would be integer division otherwise which floors automatically
                sumHours += Math.ceil((double)piles[i]/mid);
            }
            //if the value finishes the piles
            if(sumHours<=h){
                result = mid;
                r = mid -1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
}

