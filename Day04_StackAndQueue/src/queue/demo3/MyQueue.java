package queue.demo3;

import java.util.Deque;
import java.util.LinkedList;


public class MyQueue {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
      stack1.push(x);
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(empty()){
            return -1;
        }
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.peek());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty()&& stack2.isEmpty();
    }
}
