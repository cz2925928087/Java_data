package demo1;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {30,20,50,60,40};
        for (int i : array) {
            binarySearchTree.insert(i);
        }
        BinarySearchTree.TreeNode treeNode = binarySearchTree.search(40);
        System.out.println(treeNode.val);

    }
}
