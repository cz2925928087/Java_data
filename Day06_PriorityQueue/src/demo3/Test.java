package demo3;

import demo1.TestHeap;

import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        TextPriority textPriority = new TextPriority();
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(textPriority.smallestK1(arr, 4)));
    }

    public static void main(String[] args) {
        TextPriority textPriority = new TextPriority();
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(textPriority.smallestK(arr,4)));
    }

}
