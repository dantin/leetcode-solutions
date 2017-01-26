import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                // rightmost node
                if (queue.peek() == null) {
                    ans.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, null, 5, null, 4);
        TreeNode root = toTree(input);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        System.out.println(solution.rightSideView(root));
    }

    private static TreeNode toTree(List<Integer> input) {
        if (input == null || input.size() == 0) return null;

        TreeNode[] nArray = new TreeNode[input.size()];
        for (int i = 0; i < nArray.length; i++) {
            if (input.get(i) != null) {
                nArray[i] = new TreeNode(input.get(i));
            } else {
                nArray[i] = null;
            }
        }
        for (int i = 0; i < nArray.length; i++) {
            if (nArray[i] == null) continue;
            int left = 2 * (i + 1) - 1;
            int right = 2 * (i + 1);
            if (left < nArray.length) nArray[i].left = nArray[left];
            if (right < nArray.length) nArray[i].right = nArray[right];
        }

        return nArray[0];
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