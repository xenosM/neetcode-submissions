class Solution {
    public int maxArea(int[] heights) {
        //start l pointer at 0 and r pointer at n-1
        //amount of water = lowest/same value * distance between the bars
        //max amount = highest amount seen till nowabstract
        //move pointer that is the lowest value
        int l = 0, r= heights.length-1,heighestAmount=0;
        while(l<r){
            System.out.println(r);
            int amount = Math.min(heights[l],heights[r]) * (r-l);
            heighestAmount = Math.max(heighestAmount, amount);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return heighestAmount;
    }
}
