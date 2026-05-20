import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Sort {
    /*
     * 插入排序:
     * 时间复杂度:最坏情况:逆序O(N^2);
     *           最好情况:本来就是有序的O(N);
     *           应用场景:当要排序的数组趋于有序的情况下[规模不大]
     * 空间复杂度:O(1);
     * 稳定性:该排序是稳定的
     *       如果一个排序本来就是稳定的,那么可以将它实现成一个不稳定的排序
     *       如果一个排序本身是不稳定的,那么它不可能实现成一个稳定的排序
     * */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    //如果条件是arr[j]>=temp;那么就实现不稳定的排序
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /*
     * 希尔排序
     * 时间复杂度:O(N^1.3)->O(N^1.5)
     * 空间复杂度:O(1)
     * 稳定性:不稳定排序
     * */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }
    }

    public static void shell(int[] arr, int gap) {
        //i = gap ;i++:交替进行插入排序
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (arr[j] > temp) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = temp;
        }
    }

    /*
     * 堆排: 时间复杂度:O(N*logN)
     *      空间复杂度:O(1)
     *       稳定性:不稳定
     * */
    public static void heapSort(int[] arr) {
        //创建大根堆
        creatHeap(arr);
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            siftDown(arr, 0, end);
            end--;
        }
    }

    public static void creatHeap(int[] arr) {
        for (int parent = (arr.length - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(arr, parent, arr.length);
        }
    }

    public static void siftDown(int[] arr, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * 选择排序:时间复杂度:O(N^2)
     *         空间复杂度:O(1)
     * `        稳定性:不稳定
     * */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换i下标和minIndex下标
            swap(arr, i, minIndex);
        }
    }

    /*
     * 冒泡排序:时间复杂度:未加标志量O(N^2);
     *                   加了标志量最好情况下可以达到O(N)
     *        空间复杂度:O(1)
     *         稳定性:稳定
     * */
    public static void bubbleSort(int[] arr) {
        //循环趟数
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flg = true;
                }
            }
            if (!flg) {
                return;
            }
        }
    }

    /*
     * 快速排序:时间复杂度:最好情况O(NlogN)
     *                 最坏情况下:当数组有序时1,2,3,4,5  / 5,4,3,2,1的时候,时间复杂度O(n^2);
     *         空间复杂度:树的高度,最好情况O(logN) 最坏情况O(N)
     *          稳定性:不稳定
     * */
    //快排(递归)
    public static void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    public static int count = 0;

    private static void quick(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start + 1 <= 10) {
            insertSortRange(arr, start, end);
            return;
        }
        //三数取中
        int index = threeMiddle(arr, start, end);
        swap(arr, start, index);
        count++;
        int par = parttion(arr, start, end);

        quick(arr, start, par - 1);
        quick(arr, par + 1, end);
    }

    //快速排序(非递归)
    public static void quickSortNor(int[] arr) {
        quickNor(arr, 0, arr.length - 1);
    }

    public static void quickNor(int[] arr, int start, int end) {
        int par = parttion2(arr, start, end);
        Deque<Integer> stack = new LinkedList<>();
        //将per左边的两个数对放入栈里
        if (par > start + 1) {
            stack.push(start);
            stack.push(par - 1);
        }
        //将par右边的两个数对放入栈里
        if (par < end - 1) {
            stack.push(par + 1);
            stack.push(end);
        }
        //栈是否为空,如果为空就结束,每次从栈里拿出两个元素;
        while (!stack.isEmpty()) {
            int height = stack.pop();
            int low = stack.pop();
            par = parttion2(arr, low, height);
            //将per左边的两个数对放入栈里
            if (par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            //将par右边的两个数对放入栈里
            if (par < height - 1) {
                stack.push(par + 1);
                stack.push(height);
            }
        }

    }

    public static void insertSortRange(int[] arr, int low, int height) {
        for (int i = low + 1; i < height; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= low; j--) {
                if (arr[j] > temp) {
                    //如果条件是arr[j]>=temp;那么就实现不稳定的排序
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    //三数取中
    private static int threeMiddle(int[] arr, int low, int height) {
        int mid = (low + height) / 2;
        if (arr[low] < arr[height]) {
            if (arr[mid] < arr[low]) {
                return low;
            } else if (arr[mid] > arr[height]) {
                return height;
            } else {
                return mid;
            }
        } else {
            if (arr[mid] < arr[height]) {
                return height;
            } else if (arr[mid] > arr[low]) {
                return low;
            } else {
                return mid;
            }
        }
    }

    //Hoare法快排:
    private static int parttionHoare(int[] arr, int low, int height) {
        int pre = arr[low];
        //记录原来low的下标
        int i = low;
        while (low < height) {
            while (low < height && arr[height] >= pre) {
                height--;
            }
            while (low < height && arr[low] <= pre) {
                low++;
            }
            swap(arr, low, height);
        }
        swap(arr, i, low);
        return low;
    }

    //挖坑法
    public static int parttion2(int[] arr, int low, int height) {
        int temp = arr[low];
        int i = low;
        while (low < height) {
            while (low < height && arr[height] >= temp) {
                height--;
            }
            arr[low] = arr[height];
            while (low < height && arr[low] <= temp) {
                low++;
            }
            arr[height] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    //前后指针法:
    public static int parttion(int[] arr, int left, int right) {
        int pre = left;
        int cur = left + 1;
        while (cur < right) {
            if (arr[cur] < arr[left] && arr[++pre] != arr[cur]) {
                swap(arr, cur, pre);
            }
            cur++;
        }
        swap(arr, left, pre);
        return pre;
    }

    /*
     * 归并排序:时间复杂度O(N*logN)
     *         空间复杂度:O(N)
     *          稳定性:稳定排序
     * */
    //递归:
    public static void mergeSort(int[] arr) {
        mergeSortChild(arr, 0, arr.length - 1);
    }

    private static void mergeSortChild(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        //递归,分开
        mergeSortChild(arr, left, mid);
        mergeSortChild(arr, mid + 1, right);

        //合并排序:
        merge(arr, left, mid, right);

    }

    //非递归归并排序:
    public static void mergeSortNor(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            for (int i = 0; i < arr.length; i = i + 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= arr.length) {
                    mid = arr.length - 1;
                }
                int right = mid + gap;
                if (right >= arr.length) {
                    right = arr.length - 1;
                }
                merge(arr, left, mid, right);
            }

            gap *= 2;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;

        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        //保证每个子序列都有数据:\
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] <= arr[s2]) {
                temp[k++] = arr[s1++];
            } else {
                temp[k++] = arr[s2++];
            }
        }

        while (s1 <= e1) {
            temp[k++] = arr[s1++];
        }
        while (s2 <= e2) {
            temp[k++] = arr[s2++];
        }

        for (int i = 0; i < k; i++) {
            arr[i + left] = temp[i];
        }
    }

    /*
     * 计数排序:时间复杂度:O(N+范围)
     *         空间复杂度O(范围)
     *         稳定性:稳定
     * */
    public static void countSort(int[] arr) {
        //1.找到最大值和最小值:
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //2.建立一个计数数组,并且遍历原数组,当出现一个数就在Count计数数组那进行自增
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            count[index]++;
        }
        //3.遍历计数数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                arr[k] = i;
                count[i]--;
                k++;
            }
        }
    }
}
