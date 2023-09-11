package interviewtasks;

import interviewtasks.lib.bst;
import java.util.Arrays;

/**
 * leetcode.com 226. Invert Binary Tree
 * 4,2,7,1,3,6,9 -> 4,7,2,9,6,3,1
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class invertbtree {


    public static bst.TreeNode invertTree(bst.TreeNode root) {
        swap(root);
        return root;
    }

    public static void swap(bst.TreeNode node) {
        if (node == null) {
            return;
        }
        bst.TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        swap(node.left);
        swap(node.right);

    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated int array without duplicates \"4,2,7,1,3,6,9\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            bst tree = new bst();
            System.out.println(Arrays.toString(intArray));

            tree.root = tree.buildFromAnArray(intArray);
            System.out.println(tree.root.toString());

            invertTree(tree.root);

            System.out.println(tree.root.toString());

        }
    }
}
