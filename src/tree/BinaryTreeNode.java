package tree;

/**
 * @author Hongzhi Liu  liu13407134075@gmail.com
 * @date 2019/1/4 9:17
 */
public class BinaryTreeNode {
    private BinaryTreeNode lChild;
    private BinaryTreeNode rChild;

    public String message;

    public BinaryTreeNode(String message) {
        this.message = message;
    }


    public BinaryTreeNode getLChild() {
        return lChild;
    }

    public void setLChild(BinaryTreeNode lChild) {
        this.lChild = lChild;
    }

    public BinaryTreeNode getRChild() {
        return rChild;
    }

    public void setRChild(BinaryTreeNode rChild) {
        this.rChild = rChild;
    }

    public int depth() {
        if (this.lChild == null) {
            if (this.rChild == null) {
                return 1;
            } else {
                return this.rChild.depth() + 1;
            }
        } else {
            if (this.rChild == null) {
                return lChild.depth() + 1;
            } else {
                return lChild.depth() > rChild.depth() ? lChild.depth() + 1 : rChild.depth() + 1;
            }
        }
    }

    @Override
    public String toString() {
        return message;
    }
}
