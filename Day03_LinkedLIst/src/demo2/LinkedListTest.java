package demo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        //List<Integer> list1 = new LinkedList<>();
        //List<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //for循环遍历链表
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("==============");

        //foreach遍历
        for (Integer x:list) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("==============");

        //使用迭代器变量
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("==============");
        //使用反向迭代器反向遍历
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }
    }
}
