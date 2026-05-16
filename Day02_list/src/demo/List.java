package demo;

public interface List {

    //在数组最后面新增加元素
    void add(int data);

    //在pos位置新增元素
    void add(int pos,int data);

    //判断是否包含某个元素
    boolean contains(int toFind);

    //查找某个元素的位置
    int indexOf(int toFind);

    //获取pos位置的元素
    int get(int pos);

    //给pos位置的元素设为value
    void set(int pos,int value);

    //删除第一次出现的关键字key
    void remove(int toRemove);

    //获取顺序表的长度
    int size();

    //清空顺序表
    void clear();

    //打印顺序表
    void display();
}
