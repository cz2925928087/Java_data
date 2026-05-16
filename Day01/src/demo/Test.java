package demo;

import java.security.spec.RSAOtherPrimeInfo;

//写一个泛型,有一个方法,求一个数组当中的最大值,数组没有指定类型
class Array<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

}

class Array2 {
    public static <T extends Comparable<T>> T findMax2(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T findMin(T[] array) {
        T min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }
}

class Array3{
    public <T extends Comparable<T>>T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

}

public class Test {
    public static void main1(String[] args) {
        Array<Integer> array = new Array<>();
        Integer[] array1 = {1, 32, 324, 321};
        int ret = array.findMax(array1);
        System.out.println(ret);
    }

    public static void main2(String[] args) {
        Integer[] array = {1,2,3,4,5,6};
        int ret = Array2.findMax2(array);
        int ret2 = Array2.<Integer>findMin(array);
        System.out.println(ret);
        System.out.println(ret2);
    }

    public static void main(String[] args) {
        Array3 array3 = new Array3();
        Integer[] arr1 = {1, 32, 324, 321};
        int ret = array3.<Integer>findMax(arr1);
        System.out.println(ret);
    }
}