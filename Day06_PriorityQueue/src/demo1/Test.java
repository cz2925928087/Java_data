package demo1;

public class Test {
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
     TestHeap testHeap = new TestHeap();
       testHeap.init(array);
       testHeap.creatHeap();
//        testHeap.creatSmallHeap();
        System.out.println(testHeap.pool());
    }
}
