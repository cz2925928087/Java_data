package demo2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Set_test {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        //boolean add()添加元素,但是重复不会被添加,相当于自动去重了
        set.add("张三");
        set.add("张三");
        set.add("李四");
        set.add("王五");
        //返回迭代器
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //boolean contain(o) 判断o是否在集合中
        System.out.println(set.contains("张三"));//true
        //boolean remove(0) 删除集合中的o
        System.out.println(set.remove("李四"));

        //size() 返回set中元素的个数
        int setSize = set.size();
        System.out.println(setSize);//2
        //toArray 把set中元素转换为数组返回
        System.out.println(Arrays.toString(set.toArray()));
    }
}
