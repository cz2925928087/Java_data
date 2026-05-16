package demo3;
import demo.CheckPosException;
import demo.MySingleLIst;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList implements IMyLInkedLIst{
    //定义一个节点
    static class LinkList{
        public int val;
        public LinkList prv;
        public LinkList next;

        public LinkList(int val) {
            this.val = val;
        }
    }

    public LinkList head;

    public LinkList last;

    @Override
    public void addFirst(int data) {
        LinkList node = new LinkList(data);
        if(head == null) {
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prv = node;
            head = node;
        }
    }

    @Override
    public void addList(int data) {
        LinkList node = new LinkList(data);
        if(head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prv = last;
            last = node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        //检查下标是否合法
        checkPos(index);
        //当插入节点为0的时候就是头插
        if(index == 0) {
            addFirst(data);
            return;
        }
        //当插入节点为最后的时候就是尾插
        if(index == size()) {
            addFirst(data);
            return;
        }
        //处理中间插入
        LinkList node = new LinkList(data);
        LinkList cur = findIndex(index);
        node.next = cur.next;
        node.prv = cur.next.prv;
        cur.next.prv = node;
        cur.next = node;

    }
    //找到中间的节点
    private LinkList findIndex(int index) {
        LinkList cur = this.head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur ;
    }
    private void checkPos(int index) {
        if (index < 0 || index > size()) {
            throw new CheckPosException("index位置不合法" + index);
        }
    }
    @Override
    public boolean contains(int key) {
        LinkList cur = head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        //如果是空链表,就没有节点可以删除
        if(head == null) {
            System.out.println("没有节点可以删除");;
        }
        LinkList cur = head;
        while (cur != null) {
            if(cur.val == key){
                //开始删除
                if(cur == head) {
                    //删除的是头结点
                    head = head.next;
                    head.prv = null;
                }else {
                    cur.prv.next = cur.next;
                    if(cur.next == null){
                        //删除的是尾巴节点
                        last = last.prv;
                    }else {
                        //删除的是中间节点
                        cur.next.prv = cur.prv;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        //如果是空链表,就没有节点可以删除
        if(head == null) {
            System.out.println("没有节点可以删除");;
        }
        LinkList cur = head;
        while (cur != null) {
            if(cur.val == key){
                //开始删除
                if(cur == head) {
                    //删除的是头结点
                    head = head.next;
                    head.prv = null;
                }else {
                    cur.prv.next = cur.next;
                    if(cur.next == null){
                        //删除的是尾巴节点
                        last = last.prv;
                    }else {
                        //删除的是中间节点
                        cur.next.prv = cur.prv;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        LinkList cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        LinkList cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        LinkList cur = head;
        while (cur != null) {
            LinkList curN = cur.next;
            cur.next = null;
            cur.prv = null;
            cur = curN;
        }
        head = null;
        last = null;
    }
}
