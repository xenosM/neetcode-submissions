class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        ->A stack that allow allows elements in a decreasing order (Monotonic stack)
            -> a new element cannot enter the stack until all elements of the stack which are   
                smaller than the element is not popped
        ->the stack accepts a Array [temp,index]

        -> another stack(result) that has the corresponding no. of days till the warmer temp
        ->For each temp
            -> if there is an element in the stack that is smaller than current temp    
                2. get the index
                3. compute the difference in the index
                4. add the difference at the corresponding index of the popped element in the result stack
                1. pop the element
                5. add the current element
            -> else if the element is greater than the current temp
                -> add the temp along with its index
                -> add the current temp to the stack
        */

        int[] result = new int[temperatures.length];
        Stack<ArrayList<Integer>> mono = new Stack<>();

        for(int i=0;i<temperatures.length;i++){
            int current= temperatures[i] ;

            while(!mono.isEmpty() && current > mono.peek().get(0)){
                result[mono.peek().get(1)] =  i - mono.peek().get(1);  
                mono.pop();
            }   
                mono.add(new ArrayList((Arrays.asList(current,i))));
        }
        while(!mono.isEmpty()){
            result[mono.peek().get(1)] = 0;
            mono.pop();
        }
        return result;
    }
}
