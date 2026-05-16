package demo1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree implements IBinaryTree{
    public static class Tree {
        public char val;
        public Tree left;
        public Tree right;
        public Tree(char val) {
            this.val = val;
        }
    }

    Tree root;

    public Tree creatTree(){
        Tree A = new Tree('A');
        Tree B = new Tree('B');
        Tree C = new Tree('C');
        Tree D = new Tree('D');
        Tree E = new Tree('E');
        Tree F = new Tree('F');
        Tree G = new Tree('G');
        Tree H = new Tree('H');
        root = A;
        A.left = B;
        A.right = C;
        B.left=D;
        B.right = E;
        D.left = H;
        C.left = F;
        C.right = G;
        return root;
    }

    //前序遍历
    public void preOrder(Tree root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public void inOrder(Tree root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(Tree root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");;
    }

    public static int count = 0;
    @Override
    public void size(Tree root) {
        if(root == null){
            return;
        }
        count++;
        size(root.left);
        size(root.right);
    }
    public int size2(Tree root) {
        if(root == null) {
            return 0;
        }
        return size2(root.left)+size2(root.right)+1;
    }

    public static int cou =  0;
    @Override
    public void getLeafNodeCount(Tree root) {
        //遍历思路:
        if(root == null) {
            return;
        }
        if(root.left==null&&root.right==null) {
            cou++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    public int getLeafNodeCount2(Tree root){
        if(root == null) {
            return 0;
        }
        if(root.left==null&&root.right==null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }
    @Override
    public int getKLevelNodeCount(Tree root, int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }else {
            k--;
            return getKLevelNodeCount(root.left,k)+getKLevelNodeCount(root.right,k);
        }
    }

    @Override
    public int getHeight(Tree root) {
        if(root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return leftH>rightH ? leftH+1:rightH+1;
    }

    @Override
    public Tree find(Tree root, char value) {
        if(root == null){
            return null;
        }
        if(root.val == value) {
            return root;
        }
        Tree ret = find(root.left,value);
        if(ret != null) {
            return ret;
        }
        Tree ret2 = find(root.right,value);
        if(ret2 != null) {
            return ret2;
        }
        return null;
    }

    @Override
    public void levelOrder(Tree root) {
        if(root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null) {
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                queue.offer(cur.right);
            }
        }
    }



    @Override
    public boolean isCompleteTree(Tree root) {
       if(root == null) {
           return true;
       }
       Queue<Tree> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()) {
           Tree cur = queue.poll();
           if(cur != null) {
               queue.offer(cur.left);
               queue.offer(cur.right);
           }else {
               break;
           }
       }

       while (!queue.isEmpty()) {
           Tree cur = queue.peek();
           if(cur != null) {
               return false;
           }else {
               queue.poll();
           }
       }
       return true;
    }
}
