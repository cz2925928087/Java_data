package demo3;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可
* 示例：
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
* */
//topK 时间复杂度O(NlogN)
public class TextPriority {
    public int[] smallestK1(int[] arr, int k) {
        if(arr == null || k<=0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for(int i = 0;i<arr.length;i++) {
            minHeap.offer(arr[i]);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
             ret[i] = minHeap.poll();
        }
        return ret;
    }

    //时间复杂度O(NlogN);
    public int[] smallestK(int[] arr, int k) {
        if(arr == null || k<=0) {
            return new int[0];
        }
        //创建一个大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int peekVal = maxHeap.peek();
            if(peekVal > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            int val = maxHeap.poll();
            ret[i] = val;
        }
        return ret;

    }
}
