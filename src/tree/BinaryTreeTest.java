package tree;

/**
 * @author Hongzhi Liu  liu13407134075@gmail.com
 * @date 2019/1/4 9:18
 */

import intf.Test;

import java.util.Stack;

/**
 * 二叉树测试
 */
public class BinaryTreeTest implements Test {


    @Override
    public void runTest() {
        /**
         *              1
         *        2          3
         *      4   5     6    7
         *     8 9         10
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
        node6.setRChild(node10);

//        levelTraversal(node1);

//        postTraversal(node1);
//        preTraversal(node1);

        midTraversal(node1);
    }

    /**
     * 前序遍历 （非递归）
     *
     * @param root
     */
    public void preTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> rootTask = new Stack<>();
        while (null != root || !rootTask.isEmpty()) {
            if (null != root) {
                System.out.println(root);
                rootTask.push(root);
                root = root.getLChild();
            } else {
                root = rootTask.pop().getRChild();
            }
        }
    }

    /**
     * 中序遍历 （非递归）
     *
     * @param root
     */
    public void midTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> rootTask = new Stack<>();
        while (null != root || !rootTask.isEmpty()) {
            if (null != root){
                rootTask.push(root);
                root = root.getLChild();
            }else {
                root = rootTask.pop();
                System.out.println(root);
                root = root.getRChild();
            }
        }

    }


    /**
     * 后序遍历 （非递归）
     *
     * @param root
     */
    public void postTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> rootStack = new Stack<>();
        //用于输出的栈
        Stack<BinaryTreeNode> outputStack = new Stack<>();
        while (null != root || !rootStack.isEmpty()) {
            if (null != root) {
                //优先将右子节点放入root栈和输出栈
                rootStack.push(root);
                outputStack.push(root);
                root = root.getRChild();
            } else {
                //当前节点为null
                //从root栈中弹出当前节点的父节点，对他的左子节点循环该操作
                root = rootStack.pop().getLChild();

            }
        }
        //上面循环结束后，所有节点都已按顺序进入root栈
        while (!outputStack.isEmpty()) {
            System.out.println(outputStack.pop());
        }
    }


    /**
     * 层次遍历（递归）
     * 层次遍历的递归实现需要先获取树的最大深度
     */
    public void levelTraversal(BinaryTreeNode root) {
        if (root != null) {
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
