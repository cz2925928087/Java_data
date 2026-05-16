package demo2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(array.get(i - 1))) {
                array.remove(i);
                i--;
            }
        }
        int k = array.size();
        for (int i = 0; i < k; i++) {
            nums[i] = array.get(i);
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3}; // 输入数组
        int[] expectedNums = {0, 1, 2, 3}; // 预期结果

        int k = removeDuplicates(nums); // 调用你的方法

        // 测试断言
        assert k == expectedNums.length : "长度不匹配！";
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i] : "元素内容不匹配！";
        }

        System.out.println("测试通过！去重后的长度为: " + k);
        System.out.print("数组内容为: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}

