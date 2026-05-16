package queue.Demo2;

public class MyQueue {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode first;

    public ListNode last;

   //入队
   public void offer(int val) {
       ListNode node = new ListNode(val);
       if(first == null) {
          first = last = node;
       }else {
           last.next = node;
           node.prev = last;
           last = node;
       }
   }

   //出队列
    public int poll() {
        if(first == null){
            return -1;
        }
        int val = first.val;
        if(first == last) {
            first =null;
            last = null;
        }else {
            first = first.next;
            first.prev = null;
        }
        return val;
    }

    //获取队的头元素
    public int peek() {
        if(first == null) {
            return -1;
        }
        return first.val;
    }

    //获取队列的有效元素的个数
    public int size() {
        int count = 0;
        ListNode cur = first;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //判断队列是否为空
    public boolean empty() {
       if (first == null) {
           return true;
       }
       return false;
    }
}
