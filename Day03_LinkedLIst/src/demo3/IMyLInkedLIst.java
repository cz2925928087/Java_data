package demo3;

public interface IMyLInkedLIst {
    //头插法
    void addFirst(int data);

    //尾插法
    void addList(int data);

    //在任意位置插入,第一个数据节点为0
    void addIndex(int index ,int data);

    //查看是否包含关键字key的节点
    boolean contains(int key);

    //删除第一个关键数据为key的节点
    void remove(int key);

    //删除所有关键数据为key的节点
    void removeAllKey(int key);

    //得到链表长度
    int size();
    //打印链表
    void display();
    //清除链表
    void clear();
}
