class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea =0;
        for(int i=0; i<heights.length;i++){
            int startIndex = i;
            while(!stack.isEmpty() && stack.peek()[1]> heights[i]){
                int[] pop = stack.pop();
                maxArea = Math.max(maxArea, pop[1] * (i-pop[0]) );
                startIndex = pop[0];
            }
            stack.push(new int[]{startIndex,heights[i]});
        }
        for(int[] pair :stack){

            maxArea = Math.max(maxArea, pair[1] * (heights.length-pair[0]) );

        }

        
        return maxArea;
    }
}
