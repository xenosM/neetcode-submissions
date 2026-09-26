class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
           get the time taken to get to the target for each car
           creat a monotonic decreasing stacf for each car
           count the elements in the stack 
        */
        Stack<Double> stack = new Stack<>();
        double[][] timePair = new double[position.length][2];

        for(int i =0;i<position.length;i++){
            timePair[i][0] = (double)position[i];
            timePair[i][1] = (double)(target - position[i]) / speed[i];
        }
        //Sort
        Arrays.sort(timePair,(a,b)->Double.compare(a[0],b[0]));

        for(double[] car: timePair){
            while(!stack.isEmpty() && car[1]>=stack.peek()){
                stack.pop();
            }
            stack.add(car[1]);
        }
        return stack.size();
    }
}
