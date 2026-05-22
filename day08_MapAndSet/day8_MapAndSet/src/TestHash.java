import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestHash {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }


    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (set.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            func(str1, str2);
        }
    }

    public static void func(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }

        Set<Character> setBreak = new HashSet<>();
        for (char ch : str1.toUpperCase().toCharArray()) {
            if (set.contains(ch) && !setBreak.contains(ch)) {
                setBreak.add(ch);
                System.out.print(ch);
            }
        }
    }
}
