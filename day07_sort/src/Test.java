import java.util.Arrays;
import java.util.Random;

public class Test {
    //从小到大
    public static void order(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    //从大到小
    public static void notOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
    }

    //随机排序
    public static void randomOrder(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_0000);
        }
    }

    public static void main1(String[] args) {
        int[] array = new int[1_0000];
        order(array);
        //notOrder(array);
        //randomOrder(array);
        testInsertSort(array);
        testShellSort(array);
        testHeapSort(array);
        testSelectSort(array);
        testBubbleSort(array);
        testQuickSort(array);
        System.out.println(Sort.count);
    }

    public static void testInsertSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时" + (endTime - startTime));
    }

    public static void testShellSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时" + (endTime - startTime));
    }

    public static void testHeapSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时" + (endTime - startTime));
    }

    public static void testSelectSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时" + (endTime - startTime));
    }

    public static void testBubbleSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时" + (endTime - startTime));
    }

    public static void testQuickSort(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时" + (endTime - startTime));
    }

    //直接插入排序
    public static void main2(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //希尔排序
    public static void main3(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序:
    public static void main4(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序:
    public static void main5(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序:
    public static void main6(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序(递归):
    public static void main7(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序(非递归):
    public static void main8(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.quickSortNor(arr);
        System.out.println(Arrays.toString(arr));
    }

    //归并排序(递归实现)
    public static void main9(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //归并排序(非递归实现)
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {27, 15, 19, 18, 28};
        sort.mergeSortNor(arr);
        System.out.println(Arrays.toString(arr));
    }

}
