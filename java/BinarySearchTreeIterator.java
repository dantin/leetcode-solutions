import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeIterator {

    public static void main(String[] args) {

    }
}

class BSTIterator {

    Deque<TreeNode> stack;

    BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode cur = stack.pop();
        int ans = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}