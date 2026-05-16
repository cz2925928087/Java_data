package demo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    public List<List<Character>> levelOrderBottom(BinaryTree.Tree root) {
        LinkedList<List<Character>> list = new LinkedList<>();
        if(root == null) {
            return  list;
        }
        Queue<BinaryTree.Tree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Character> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                demo1.BinaryTree.Tree node = queue.poll();
                cur.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            list.addFirst(cur);
        }
       return list;
    }
}
