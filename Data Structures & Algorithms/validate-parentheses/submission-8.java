class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a=='['|| a=='(' || a=='{' ){
                System.out.println("push: "+ a);
                stack.push(String.valueOf(a));
                
            }
            else{
                if(stack.isEmpty()) return false;
                String top = stack.peek();
                System.out.println("a: "+ a);
                System.out.println("top: "+ top);
                if(a==']' && top.equals("[")){

                    stack.pop();
                    System.out.println("popped: "+ top);
                }
                else if(a=='}' && top.equals("{")){
                    stack.pop();
                    System.out.println("popped: "+ top);
                }
                else if(a==')' && top.equals("(")){
                    stack.pop();
                    System.out.println("popped: "+ top);
                }
                else{
                    return false;
                }
                
            }
        }
        return stack.isEmpty();
    }
}
