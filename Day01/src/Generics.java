public class Generics<T> {
    public static void main1(String[] args) {
        MyArray myArray = new MyArray();
        myArray.setVal(0, 10);
        myArray.setVal(1, 20);
        Integer ret = (int) myArray.getPos(1);
        System.out.println(ret);
    }
}

class MyArray {
    public Object[] array = new Object[10];

    public Object getPos(int pos) {
        return this.array[pos];
    }

    public void setVal(int pos, Object val) {
        this.array[pos] = val;
    }
}

//定义泛型类:class 泛型类名称<类型形参列表>
/*
T:Type泛型类
E:Element,元素
K:Key,键
V:Value,值
N:Number,数值类型
* */
class MyArray_<T> {
    public Object[] array = new Object[10];

    public T getPos(int pos) {
        return (T) this.array[pos];
    }

    public void setVal(int pos, Object val) {
        this.array[pos] = val;
    }
}

class TestDemo {
    public static void main(String[] args) {
        MyArray_<String> myArray = new MyArray_<>();//泛型类<实参类型> 变量名 = 实例化一个泛型对象:new 变量名<>();
        myArray.setVal(0, 10);
        myArray.setVal(1, "world");
        //String ret1 = myArray.getPos(0);//编译会爆出异常:因为在上注释的是String类型
        String ret = myArray.getPos(1);
        //System.out.println(ret1);
        System.out.println(ret);
    }
}