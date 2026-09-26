class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        //push token on stack
        //if token is +-*/
         //then evaluate the prev two numbers
         //push the result back on the stack
        //return the last remaining value in the stack
        for(String token:tokens){
            System.out.println(token);
            String result =token;
            int a=0,b=0;
            switch(token){
            case "+":
                a = Integer.parseInt(stack.peek());
                stack.pop();
                b = Integer.parseInt(stack.peek());
                stack.pop();
                result = String.valueOf(a+b);
            System.out.println("result"+result);

                break;
            case "*":
                  a = Integer.parseInt(stack.peek());
                stack.pop();
                b = Integer.parseInt(stack.peek());
                stack.pop();
                result = String.valueOf(a*b);
            System.out.println("result"+result);

                break;
            case "-":
                
                a = Integer.parseInt(stack.peek());
                stack.pop();
                b = Integer.parseInt(stack.peek());
                stack.pop();
                result = String.valueOf(b-a);
            System.out.println("result"+result);

                break;
            case "/":
                  a = Integer.parseInt(stack.peek());
                stack.pop();
                b = Integer.parseInt(stack.peek());
                stack.pop();
                result = String.valueOf(b/a);
            System.out.println("result"+result);

                break;
            }

            stack.push(result);
        }
        return Integer.parseInt(stack.peek());
    }
}
