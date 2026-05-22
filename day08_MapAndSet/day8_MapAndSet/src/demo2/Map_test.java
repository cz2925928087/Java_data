package demo2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class student{}

public class Map_test  {


    public static void main(String[] args) {
        Map<student,Integer> map = new TreeMap<>();
        map.put(new student(),10);
    }
    public static void main1(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        //put(k,v);设置key对应的value;
        map.put("张三", 1);
        map.put("李四", 4);
//        //get(key) 返回对应的value,没有返回null;
//        Integer V1 = map.get("张三");//1
//        Integer V2 = map.get("张三1");//找不到张三1,返回null
//        //getOrDefault(key,defaultValue);返回key对应的value,没有找到返回defaultValue设置的默认值
//        Integer V3 = map.getOrDefault("李四",321);//返回4
//        Integer V4 = map.getOrDefault("李四2",321);//返回321,找不到李四2,返回默认值321
//        System.out.println(V1);
//        System.out.println(V2);
//        System.out.println(V3);
//        System.out.println(V4);
//        //remove(key);删除key对应的value
//        map.remove("张三");
//        Integer V5 = map.get("张三");//返回null
//        System.out.println(V5);
        //Set<K> keySet返回所有key不重复的集合
        Set<String> set = map.keySet();//[张三,李四]
        System.out.println(set);
        //Collection<V> values返回所有value不重复的集合
        Collection<Integer> collection = map.values();//[1,4]
        System.out.println(collection);

        //Set<Map.Entry<K,V>> entrySet() 返回所有key-value的映射关系
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            /*key:张三value:1
              key:李四value:4*/
            System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
        }
        System.out.println(entrySet);//[张三=1, 李四=4]

        //Boolean containsKey 判断是否包含了key;
        //Boolean containValue 判断是否包含了value;
        Boolean containsKey = map.containsKey("张三");//true
        Boolean containValue = map.containsValue(1);//true
        System.out.println(containsKey);
        System.out.println(containValue);
    }
}

