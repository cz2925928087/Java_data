package demo2;

public class Test {

    //使用通配符'?'当不知道是什么类型的时候可以使用通配符
    public static void fun(Message<?> message) {
        System.out.println(message.getMessage());
    }

    public static<T> void func(Message<T> message) {
        System.out.println(message.getMessage());
    }

    public static void main(String[] args) {
        Message<Integer> message = new Message<>();
        message.setMessage(55);
        fun(message);
        func(message);
    }
}