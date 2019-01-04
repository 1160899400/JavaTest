package tree;

/**
 * @author Hongzhi Liu  liu13407134075@gmail.com
 * @date 2019/1/4 9:18
 */

import intf.Test;

/**
 * 二叉树测试
 */
public class BinaryTreeTest implements Test {


    @Override
    public void runTest() {
        /**
         *            1
         *        2      3
         *      4   5   6  7
         *     8 9 10
         */
        BinaryTreeNode node1 = new BinaryTreeNode("1");
        BinaryTreeNode node2 = new BinaryTreeNode("2");
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node4 = new BinaryTreeNode("4");
        BinaryTreeNode node5 = new BinaryTreeNode("5");
        BinaryTreeNode node6 = new BinaryTreeNode("6");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node8 = new BinaryTreeNode("8");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node10 = new BinaryTreeNode("10");
        node1.setLChild(node2);
        node1.setRChild(node3);
        node2.setLChild(node4);
        node2.setRChild(node5);
        node3.setLChild(node6);
        node3.setRChild(node7);
        node4.setLChild(node8);
        node4.setRChild(node9);
        node5.setLChild(node10);

        levelTraversal(node1);


    }


    /**
     * 层次遍历（递归）
     * 层次遍历的递归实现需要先获取树的最大深度
     */
    public void levelTraversal(BinaryTreeNode root) {
        if (root != null){
            int height = root.depth();
            System.out.println(height);
            for (int i = 1; i <= height; i++) {
                levelTraversal(root, i);
            }
        }

    }

    private void levelTraversal(BinaryTreeNode node, int level) {
        if (node != null) {
            if (level <= 1) {
                System.out.println(node);
            } else {
                level--;
                levelTraversal(node.getLChild(), level);
                levelTraversal(node.getRChild(), level);
            }
        }
    }


}
