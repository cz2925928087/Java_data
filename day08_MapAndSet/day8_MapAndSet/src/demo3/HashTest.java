package demo3;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


class Student {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


public class HashTest {

    public static void main1(String[] args) {
        Map<Student,String> map = new HashMap<>();
        Student student = new Student("1234");
        map.put(student,"张三");
        String s = map.get(student);
        System.out.println(s);
    }

    public static void main(String[] args) {
        Student student = new Student("123243");
        int hashCode = student.hashCode();
        System.out.println(hashCode);
        Student student2 = new Student("123243");
//        hashCode = student.hashCode();
//        System.out.println(hashCode);

        HashBuck2<Student, String> hashBuck2 = new HashBuck2<>();
        hashBuck2.push(student, "oooooo");
        String m = hashBuck2.get(student2);
        System.out.println(m);
    }
}
