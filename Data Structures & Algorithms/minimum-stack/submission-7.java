class MinStack {

    /*
    declare var min (null)
    whenever you push 
        if min is null then min = push value
        compare with the min if push value is greater than min
        get min just return min

        
        2
        1
        2
        3
    */

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
