package queue.Demo2;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(10);
        myQueue.offer(20);
        myQueue.offer(30);
        System.out.println(myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.empty());
    }
}
