package queue.Demo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        //入队列
        list.offer(10);
        list.offer(20);
        list.offer(30);
        System.out.println(list);
        //出队列
        System.out.println(list.poll());
        //查看队列头元素
        System.out.println(list.peek());
        //获取队列的有效元素个数
        int size = list.size();
        System.out.println(size);
        //判断队列是否为空
        System.out.println(list.isEmpty());
    }

}
