package demo1;


public class BinaryTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Tree root = binaryTree.creatTree();

        System.out.println("前序遍历:");
        binaryTree.preOrder(root);

        System.out.println();
        System.out.println("中序遍历:");
        binaryTree.inOrder(root);

        System.out.println();
        System.out.println("后序遍历:");
        binaryTree.postOrder(root);

        System.out.println();
        System.out.println("节点个数: ");
        binaryTree.size(root);
        System.out.println(BinaryTree.count);
        System.out.print("节点个数:"+binaryTree.size2(root));

        System.out.println();
        System.out.println("叶子节点数");
        binaryTree.getLeafNodeCount(root);
        System.out.println(BinaryTree.cou);
        System.out.print("叶子节点数:"+binaryTree.getLeafNodeCount2(root));

        System.out.println();
        System.out.println("第k层的节点数:");
        System.out.print("第3层节点数:"+binaryTree.getKLevelNodeCount(root,3));

        System.out.println();
        System.out.println("一共有多少层:");
        System.out.print(binaryTree.getHeight(root));

        System.out.println();
        System.out.println("是否找到value");
        BinaryTree.Tree tree = binaryTree.find(root,'G');
        System.out.print(tree.val);

        System.out.println();
        System.out.println("层序遍历");
        binaryTree.levelOrder(root);

        System.out.println();
        System.out.println("判断树是否为完全二叉树");
        boolean res = binaryTree.isCompleteTree(root);
        System.out.println(res);
    }
}
