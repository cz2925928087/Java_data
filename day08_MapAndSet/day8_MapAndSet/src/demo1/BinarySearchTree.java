package demo1;

import java.util.Random;

/*
 * 二叉搜索树(二叉排序树):左子树不为空,左子树小于跟节点,右子树不为空,右子树大于根节点
 *                     相当于中序遍历的结果是有序(从小到大的)
 * */
public class BinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode root;

    /*
     * 查找节点:时间复杂度:最好情况下满二叉树/完全二叉树O(logN)
     *                   最坏情况下单分支查找O(N)
     *
     *
     * */
    public TreeNode search(int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    /*
     * 插入节点:时间复杂度:最好情况:O(logN);
     *                   最坏情况O(N);
     * */
    public boolean insert(int val) {
        //如果节点为空直接插入:
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        //如果节点不为空,则将这个插入值和每个节点进行比较,如果小于根节点就向左查,大于就向右查,直到为空
        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                //插入值和节点值相等,插入失败
                return false;
            }
        }
        if (val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    /*
     * 删除节点:需要讨论三种情况当没有左孩子,没有右孩子,或者左右都有孩子情况的三种情况,
     *          当左右都有孩子的时候不能简单删除,可以使用替换删除(在其⼦树中找⼀个替代节点进⾏删除)
     *
     * */
    public void remove(int val) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;

        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                removeNode(parent, cur);
                return;
            }
        }

    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            } else {
                parent.left = cur.left;
            }
        } else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}
