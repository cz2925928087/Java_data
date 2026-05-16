package demo2;

import java.util.LinkedList;
import java.util.Stack;

public class Text {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        int ret = stack.peek();
        System.out.println(ret);
        stack.pop();
        System.out.println(stack);
    }


    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        int PopVal = myStack.pop();
        System.out.println(PopVal);//4

        int PeekVal = myStack.peek();
        int PeekVal2 = myStack.peek();
        System.out.println(PeekVal);//3
        System.out.println(PeekVal2);//3

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(!isOperation(str)) {
                stack.push(Integer.parseInt(str));
            }else {
                int val = stack.pop();
                int val2 = stack.pop();
                switch(str){
                    case "+":
                        stack.push(val+val2);
                        break;
                    case "-":
                        stack.push(val-val2);
                        break;
                    case "*":
                        stack.push(val*val2);
                        break;
                    case "/":
                        stack.push(val/val2);
                        break;
                }
            }

        }
        return stack.pop();
    }

    public boolean isOperation(String s) {
        if(s == ("+") || s == ("-")|| s ==  ("*")|| s ==  ("/")) {
            return true;
        }
        return false;
    }
}
