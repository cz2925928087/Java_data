package demo3;


public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;

    //定义负载因子:
    public static final double LOAD_FACTOR = 0.75;

    public HashBuck() {
        this.array = new Node[10];
    }

    public void push(int key, int val) {
        int index = key % array.length;
        Node cur = array[index];

        //当插入节点一样的时候,要更新val
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        //进行插入
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        usedSize++;

        if (CalcFactor() >= LOAD_FACTOR) {
            /*扩容:(两倍扩容)
             * 扩容后,可能原来数组当中的节点就不在扩容后的那个下标位置了
             * 这时候需要对这个散列表进行重新哈希
             * */
            resize();
        }
    }

    private void resize() {
        //扩容
        Node[] newArray = new Node[array.length * 2];
        //重新哈希
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int newIndex = cur.key % newArray.length;
                //开始头插
                Node curN = cur.next;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curN;
            }
        }
    }

    private double CalcFactor() {
        return usedSize * 1.0 / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur!=null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur= cur.next;
        }
        return -1;
    }

}
