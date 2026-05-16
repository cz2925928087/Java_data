public class PackGroup {
    public static void main1(String[] args) {
        int a = 10;
        //拆箱和装箱
        /*拆箱:将包装类型->基本类型
        * 装箱:将基本类型->包装类型
        * */
        //手动装箱
        Integer i = Integer.valueOf(a);
        //自动装箱
        Integer ji = a;
        System.out.println(a);
        System.out.println(i);
        System.out.println(ji);
        System.out.println("========");
        Integer b = 100;
        //手动拆箱
        int j = Integer.valueOf(b);
        //自动拆箱
        int ij = b;
        System.out.println(b);
        System.out.println(j);
        System.out.println(ij);
    }

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a==b);//Integer有范围-127~127
        System.out.println(c==d);
    }
}