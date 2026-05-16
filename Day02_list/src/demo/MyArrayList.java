package demo;

import java.util.Arrays;

public class MyArrayList implements List{
    //存储数组
    public int[] array;
    //记录数组中有效的数据个数
    public int useSized;

    public MyArrayList() {
        this.array = new int[Constant.DEFAULT_CAPACITY];
    }


    @Override
    public void add(int data) {
        if(isFull()){
            grow();
            System.out.println("扩容了");
            System.out.println(array.length);
        }

        this.array[this.useSized] = data;
        this.useSized++;
    }
    //扩容
    private void grow() {
        this.array = Arrays.copyOf(this.array,2*this.array.length);
    }

    //判断是否越界
    private boolean isFull() {
        return this.useSized == this.array.length;
    }

    @Override
    public void add(int pos, int data) {
        if(isFull()) {
            grow();
        }
        String msg = Constant.EMPTY_LIST;
        checkPosAdd(pos,msg);
        //判断pos是不是放在了useSized上面
        if(pos == useSized) {
            array[pos] = data;
            this.useSized++;
            return;
        }
        //从后往前移动
        for (int i = useSized-1; i >= pos ; i--) {
            array[i+1] = array[i];
        }
        array[pos] = data;
        this.useSized++;
    }

    private void checkPosAdd(int pos,String msg) {
        if(pos < 0 || pos > this.useSized) {
            throw new PosIllegal();
        }
    }
    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < this.useSized; i++) {
            if(array[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < this.useSized; i++) {
            if(array[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        if(isEmpty()) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        String msg = Constant.EMPTY_LIST;
        checkPos(pos,msg);
        return array[pos];
    }


    private void checkPos(int pos,String msg) {
        if(pos < 0 || pos >= useSized) {
            throw new PosIllegal();
        }
    }
    public boolean isEmpty() {
        return useSized == 0;
    }

    @Override
    public void set(int pos, int value) {
        if(isEmpty()) {
            throw new EmptyListException();
        }
        String msg = Constant.SET_POS_ILLEGALITY;
        checkPos(pos,msg);
        array[pos] =value;
    }

    //删除方法1,顺序表是空,2,查有没有要删除的数字,3,记录下来要删除的元素的下标,4,删除以覆盖的形势进行删除
    @Override
    public void remove(int toRemove) {
        if(isEmpty()) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        int index = indexOf(toRemove);
        if(index == -1) {
            System.out.println("没有要删除的数字");
            return ;
        }
        for (int i = index; i < useSized-1; i++) {
            array[i] = array[i+1];
        }
        useSized--;
        //如果为引用类型,需要手动设为空
        //array[useSized] = null;
    }

    @Override
    public int size() {
        return useSized;
    }

    @Override
    public void clear() {
        for (int i = 0; i < useSized; i++) {
            array[i] = 0;
            //如果为引用类型,需要手动将元素设为空
            //array[i] = null;
        }
        useSized = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.useSized; i++) {
            System.out.print(this.array[i]+" ");
        }
        System.out.println();
    }
}
