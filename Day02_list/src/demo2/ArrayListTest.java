package demo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main1(String[] args) {
        //不带参数的ArrayLIst构造方法
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        System.out.println(arrayList1);

        //定义一个初始容量为10的arrayList
        ArrayList<Integer> arrayList2 = new ArrayList<>(3);
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(2);
        arrayList2.add(3);
        System.out.println(arrayList2);

        //利用其他的Collection接口来构造ArrayList
        ArrayList<Integer> arrayList3 = new ArrayList<>(arrayList1);//arrayList3构建后,其元素和arrayList一致
        System.out.println(arrayList3);
    }

    public static void main3(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0,4);//4,1,2,3
        System.out.println(list);
        Integer ii= 2;
        list.remove(ii);
       // list.remove((Object)2);//删除2这个元素4,1,3
        System.out.println(list);
        list.remove(0);//删除下标0这个位置上的元素4,结果1,3
        System.out.println(list);

        System.out.println("==============");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(list);//将list的元素尾插到list1中
        System.out.println(list1);

        System.out.println("=================");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        List<Integer> subList = arrayList.subList(1,3);//[1,3)
        System.out.println(subList);
     }

     //遍历ArrayList
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        //用for循环
        System.out.println("====for循环遍历====");
        for(int i = 0;i < arrayList.size();i++) {
            System.out.print(arrayList.get(i)+ " ");
        }
        System.out.println();
        System.out.println("====foreach遍历 =====");
        //用foreach遍历
        for(Integer integer : arrayList) {
            System.out.print(integer+" ");
        }
        System.out.println();
        //迭代器
        System.out.println("====迭代器====");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println("====迭代器2====");
        Iterator<Integer> iterator1 = arrayList.listIterator(2);//从2下标开始截取打印3,4
        while(iterator1.hasNext()) {
            System.out.print(iterator1.next()+" ");
        }
        System.out.println();

        //逆向打印
        System.out.println("====迭代器3====");
        ListIterator<Integer> iterator2 = arrayList.listIterator(arrayList.size());
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous()+" ");
        }
    }
}
