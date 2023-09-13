package interviewtasks;

import interviewtasks.lib.bst;

/**
 * leetcode.com 104. Maximum Depth of Binary Tree
 * 4,2,7,1,3,6,9 ->
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class treebstdepth {


    public static int counter(bst.TreeNode root) {
        return new treebstdepth().maxDepthRunner(root, 0);

    }

    private int maxDepthRunner(bst.TreeNode node, int counter) {

        if (node != null) {
            int localCounter = counter + 1;
            if (node.left != null) {
                localCounter = maxDepthRunner(node.left, counter + 1);
            }
            if (node.right != null) {
                localCounter = Math.max(localCounter, maxDepthRunner(node.right, counter + 1));
            }

            return localCounter;
        }

        return counter;
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
            tree.root = tree.buildFromAnArray(intArray);

            System.out.println(tree.root.toString());
            System.out.println(":" + counter(tree.root));
        }
    }
}
