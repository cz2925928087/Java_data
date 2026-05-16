package demo;

import java.util.List;

public class MySingleLIst implements ILinkedList {
    //单个节点的属性
    static class ListNode {
        public int val;//存储数据
        public ListNode next;//节点的引用

        public ListNode(int val) {
            this.val = val;
        }
    }

    //储存头节点的引用
    public ListNode head;

    public void createLIst() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(32);
        ListNode node4 = new ListNode(43);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = node1;
    }

    @Override
    public void addFirst(int data) {
        //实例一个节点对象
        ListNode node = new ListNode(data);
        //1、将该对象的next域指向head
        node.next = head;
        //2、将head前移动
        head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            return;
        }
        //找到链表的尾巴
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //cur指向的就是链表的尾巴节点
        cur.next = node;

    }

    @Override
    public void addIndex(int index, int data) {
        //检查节点是否合法
        checkPos(index);
        //当插入节点为0就是头插
        if (index == 0) {
            addFirst(data);
            return;
        }
        //当插入节点为最后一个就是尾插
        if (index == size()) {
            addLast(data);
            return;
        }
        //处理中间插入
        ListNode node = new ListNode(data);
        ListNode cur = findIndex(index);
        node.next = cur.next;
        cur.next = node;

    }

    //找到中间插入节点的位置
    private ListNode findIndex(int index) {
        ListNode cur = this.head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkPos(int index) {
        if (index < 0 || index > size()) {
            throw new CheckPosException("index位置不合法" + index);
        }
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (head == null) {
            System.out.println("该链表为空,无法进行删除");
            return;
        }
        //删除头结点
        if (head.val == key) {
            head = head.next;
            return;
        }
        //删除中间的节点
        ListNode cur = search(key);
        if(cur == null) {
            System.out.println("没有要删除的数字"+key);
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }

    //找到要删除节点的前一个节点
    private ListNode search(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur =cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        if(head == null) {
            return;
        }
        ListNode cur = this.head.next;
        ListNode prv = head;
        while (cur != null) {
            if(cur.val == key) {
                prv.next = cur.next;
                cur =cur.next;
            }else {
                prv = cur;
                cur =cur.next;
            }
        }
        if(head.val == key) {
            head = head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            cur.val = 0;
            ListNode curN =cur.next;
            cur.next = null;
            cur = curN;
        }
        head = null;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public boolean chkPalindrome() {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        //1->找中间节点
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2->翻转中间节点之后的节点
        ListNode cur = null;
        if (slow != null) {
            cur = slow.next;
        }
        while(cur != null) {
            ListNode curN = cur.next;
            cur.next = slow;
            cur = curN;
        }
        //3->前后一起移动,直到相遇
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}


