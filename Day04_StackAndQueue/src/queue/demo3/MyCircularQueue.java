package queue.demo3;

public class MyCircularQueue {
    public int[] elem;
    public int rear;
    public int front;

    //MyCircularQueue(k): 构造器，设置队列长度为 k
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    //向循环队列插入一个元素。如果成功插入则返回真
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    //从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }

    //从队首获取元素。如果队列为空，返回 -1
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    //获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = -1;
        if (rear == 0) {
            index = elem.length - 1;
        } else {
            index = rear - 1;
        }
        return elem[index];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }
}
