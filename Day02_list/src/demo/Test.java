package demo;

public class Test {

    public static void main(String[] args) {

    }
    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,22);
        myArrayList.add(1,23);
        myArrayList.add(2,431);
        myArrayList.display();

        myArrayList.remove(22);
        myArrayList.display();
    }
    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.display();
        System.out.println(myArrayList.useSized);
        System.out.println(myArrayList.contains(5));//true
        System.out.println(myArrayList.indexOf(4));//9
        System.out.println("============");
       try {
           int i =myArrayList.get(3);
           System.out.println(i);
       }catch (EmptyListException e) {
           e.printStackTrace();
       }catch (PosIllegal e) {
           e.printStackTrace();
       }

    }

}
