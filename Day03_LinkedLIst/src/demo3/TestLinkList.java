package demo3;

public class TestLinkList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //头插法
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        //打印链表:头插法:
        myLinkedList.display();

        //打印节点数
        int ret = myLinkedList.size();
        System.out.println("节点数为 "+ ret);
        //判断是否包含key
        boolean ret2 = myLinkedList.contains(4);
        boolean ret3 = myLinkedList.contains(5);
        System.out.println("是否包含key:4 "+ret2);
        System.out.println("是否包含key:5 "+ret3);
        System.out.println("==========");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        //尾插法
        myLinkedList1.addList(1);
        myLinkedList1.addList(2);
        myLinkedList1.addList(3);
        myLinkedList1.addList(4);
        myLinkedList1.addList(4);
        myLinkedList1.display();
        myLinkedList1.addIndex(0,9);
        myLinkedList1.addIndex(2,5);
        myLinkedList1.display();
        myLinkedList1.remove(9);//删除头节点
        myLinkedList1.remove(2);//删除中间节点
        //myLinkedList1.remove(4);//删除尾巴节点
        myLinkedList1.removeAllKey(4);//删除所有的4
        myLinkedList1.display();
        myLinkedList1.clear();
        myLinkedList1.display();
    }

}
