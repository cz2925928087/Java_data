package demo2;


import java.util.Arrays;

public class MyStack<E> {
    public Object[] element;
    public int useSized;
    public static final int DEFAULT_CAPACITY = 5;

    public MyStack() {
        element = new Object[DEFAULT_CAPACITY];
    }

    //push入栈
    public void push(E val) {
        if (isFull()) {
            element = Arrays.copyOf(element,2*element.length);
        }
        element[useSized] = val;
        useSized++;
    }
    //判断是否满了
    private boolean isFull() {
        return useSized == element.length;
    }

    //pop出栈
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        E ret = (E)element[useSized-1];
        useSized--;
        return ret;
    }
    //判断是否为空
    private boolean isEmpty() {
        return useSized == 0;
    }

    //peek,找到栈顶的的值,不删除
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        E ret = (E)element[useSized-1];
        return ret;
    }
}
