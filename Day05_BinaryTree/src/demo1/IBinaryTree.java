package demo1;



public interface IBinaryTree {
    //获取树中节点个数
    void size(BinaryTree.Tree root);
    // 获取叶⼦节点的个数
    void getLeafNodeCount(BinaryTree.Tree root);
    //获取第k层的节点个数
    int getKLevelNodeCount(BinaryTree.Tree root,int k);
    // 获取⼆叉树的⾼度
    int getHeight(BinaryTree.Tree root);
    // 检测值为value的元素是否存在
    BinaryTree.Tree find(BinaryTree.Tree root,char value);

    //层序遍历
    void levelOrder(BinaryTree.Tree root);
    // 判断⼀棵树是不是完全⼆叉树
    boolean isCompleteTree(BinaryTree.Tree root);
}
