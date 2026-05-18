package demo2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityTest {
    public static void main1(String[] args) {
        //Java提供的PriorityQueen优先级队列默认是构建小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        System.out.println(priorityQueue.peek());//2
    }

    /*
    * 如果需要创建大根堆,则需要重写比较器
    * */
    static class IntCmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new IntCmp());
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        System.out.println(priorityQueue.peek());
     }

}
