class Solution {
    public int trap(int[] height) {
    /*
    When does a point hold water?
    1. the bars to be considerd should be the tallest possible bar on either side
    2. here should be a bar at both side are taller than the point
        =>bar(l) & bar(r) > bar(i)
    3. with the minimum  amount being the height of the smallest bar
        =>amount of water = min(l,r) - height of bar(i)
    */

    //For each bar(i)
        //store the tallest bar on the right
        //store the tallest bar on the left
        //get the minimum height of the bar
        //calculate the amount of water that is possible on i
    int[] lHighest = new int[height.length];
    int[] rHighest = new int[height.length];
    int ltallest=0,rtallest=0, totalAmount=0;
    int n = height.length-1;
        for(int i=0;i<height.length;i++){
            lHighest[i]=ltallest;
            rHighest[n-i] = rtallest;
            if(height[i]>ltallest){
                ltallest = height[i];
            }
            if(height[n-i] >rtallest){
                rtallest = height[n-i];
            }
        }
        for(int i=0;i<height.length;i++){
            int amount = Math.min(lHighest[i],rHighest[i]) -height[i];
            if(amount >0) totalAmount +=amount;
        }
        return totalAmount;
    }
}
