package demo3;


public class HashBuck2<K, V> {
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array;
    public int usedSize;
    public static final double LOAD_FACTOR = 0.75;

    public HashBuck2() {
        array = (Node<K, V>[]) new Node[10];
    }

    public void push(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K, V> cur = array[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;
                return;
            }
        }
        Node<K, V> node = new Node<>(key, val);
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
        Node<K, V>[] newArray = new Node[array.length * 2];
        //重新哈希
        for (int i = 0; i < array.length; i++) {
            Node<K, V> cur = array[i];
            int hash = cur.key.hashCode();
            while (cur != null) {
                int newIndex = hash % newArray.length;
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

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void print() {
        System.out.println("说自己是m");
    }
}
