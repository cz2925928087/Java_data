package demo1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void init(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    /*
     * 创建大根堆 时间复杂度O(n)
     * */
    public void creatHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(parent, usedSize);
        }
    }

    private void siftDown(int parent, int usedSize) {
        int child = parent * 2 + 1;
        while (child < usedSize) {
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child++;
            }

            if (elem[child] > elem[parent]) {
                swap(elem, parent, child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }

    }

    //创建小根堆 O(N)
    public void creatSmallHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown2(parent, usedSize);
        }
    }

    private void siftDown2(int parent, int usedSize) {
        int child = parent * 2 + 1;
        while (child < usedSize) {

            if (child + 1 < usedSize && elem[child] > elem[child + 1]) {
                child++;
            }

            if (elem[child] < elem[parent]) {
                swap(elem, child, parent);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    //交换
    public void swap(int[] elem, int i, int j) {
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }
    //在堆中插入元素;
    public void offer(int val) {
        if(isFull()) {
            //扩容
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        siftUp(usedSize-1);

    }

    public void siftUp(int child) {
        //1parent
        int parent = (child-1)/2;
        //开始持续调整
        while(child > 0) {
            if(elem[child]>elem[parent]) {
                swap(elem,child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    //判断数组是否满了
    private boolean isFull() {
        return usedSize == elem.length;
    }

    //删除元素,将0下标和最后的一个元素交换,然后向下调整
    public int pool() {
        if (isEmpty()) {
            return -1;
        }
        int ret = elem[0];
        swap(elem, 0, usedSize - 1);
        usedSize--;
        siftDown(0, usedSize);
        return ret;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }


    //查看堆头
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return elem[0];
    }

    /*
     * 堆排序
     * 时间复杂度O(N*logN)
     * 空间复杂度O(1)
     * */
    public void heapSort(int[] elem, int usedSize) {
        int end = usedSize - 1;
        while (end > 0) {
            swap(elem, 0, end);
            siftDown(0, end);
            end--;
        }
    }
}
