import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        double x = 0.1;
        double y = 0.2;
        double z = 0.4;

        System.out.println(x+y);
        System.out.println(x+z);

        BigDecimal bigDecimal = new BigDecimal(0.1);
        BigDecimal bigDecimal1 = new BigDecimal(0.2);
        BigDecimal bigDecimal2 = new BigDecimal(z);
        BigDecimal bigDecimal3 = bigDecimal.add(bigDecimal1);
        System.out.println(bigDecimal3);
        System.out.println(bigDecimal3.equals(bigDecimal3));
    }
}
