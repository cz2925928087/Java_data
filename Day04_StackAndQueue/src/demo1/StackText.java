package demo1;

import java.util.Stack;

public class StackText {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //压栈
        stack.push(21);
        stack.push(32);
        stack.push(13);
        //pop就是出栈:获取栈顶元素并出栈
//        int ret = stack.pop();//13
//        System.out.println(ret);
//        int ret2 = stack.pop();//32
//        System.out.println(ret2);
        //获取栈顶元素,与pop的区别是peek不出栈
        int ret3 = stack.peek();
        System.out.println(ret3);//13
        int ret4 = stack.peek();
        System.out.println(ret4);//13
    }
}
