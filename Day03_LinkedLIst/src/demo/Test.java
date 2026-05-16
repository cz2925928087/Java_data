package demo;

public class Test {
    public static void main1(String[] args) {
        MySingleLIst mySingleLIst = new MySingleLIst();
        mySingleLIst.createLIst();
        mySingleLIst.display();
        int ret = mySingleLIst.size();
        System.out.println("size: " + ret);
        boolean ret1 = mySingleLIst.contains(13);
        System.out.println(ret1);

        //头插入一个99
        System.out.println("头插入");
        mySingleLIst.addFirst(99);
        mySingleLIst.display();

        //尾插入一个88
        System.out.println("尾插入");
        mySingleLIst.addLast(99);
        mySingleLIst.display();

        //中间插一个77
        System.out.println("中间插入");
        mySingleLIst.addIndex(2,77);
        mySingleLIst.display();

        //删除中间的节点77
        System.out.println("删除单个key");
        mySingleLIst.remove(77);
        mySingleLIst.display();
        //删除所有为99的节点
        System.out.println("删除所有key");
        mySingleLIst.removeAllKey(99);
        mySingleLIst.display();
        System.out.println("清空");
        mySingleLIst.clear();
        mySingleLIst.display();
    }

    public static void main(String[] args) {
        MySingleLIst mySingleLIst = new MySingleLIst();
        mySingleLIst.addLast (11);
        mySingleLIst.addLast(12);
        mySingleLIst.addLast(13);
        mySingleLIst.addLast(12);
        mySingleLIst.addLast(11);

        boolean b = mySingleLIst.chkPalindrome();
        System.out.println(b);
    }
}
