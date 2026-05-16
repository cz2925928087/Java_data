package queue.demo3;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public Queue<Integer> qu1;
    public Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!qu1.isEmpty()) {
            qu1.offer(x);
        } else if (!qu2.isEmpty()) {
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            while (size - 1 != 0) {
                int val = qu1.poll();
                qu2.offer(val);
                size--;
            }
            return qu1.poll();
        } else {
            int size = qu2.size();
            while (size - 1 != 0) {
                int val = qu2.poll();
                qu1.offer(val);
                size--;
            }
            return qu2.poll();
        }
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            int val = -1;
            while (size != 0) {
                val = qu1.poll();
                qu2.offer(val);
                size--;
            }
            return val;
        } else {
            int size = qu2.size();
            int val = -1;
            while (size != 0) {
                val = qu2.poll();
                qu1.offer(val);
                size--;
            }
            return val;
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
