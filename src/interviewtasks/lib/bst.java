package interviewtasks.lib;


import java.util.*;

public class bst {
    public TreeNode root;
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            print("", this, false);
            return "";
        }
        public void print(String prefix, TreeNode n, boolean isLeft) {
            if (n != null) {
                System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.val);
                print(prefix + (isLeft ? "|   " : "    "), n.left, true);
                print(prefix + (isLeft ? "|   " : "    "), n.right, false);
            }
        }
    }
    // More then one element expected
    public TreeNode buildFromAnArray(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {

            insert(root,arr[i]);
        }
        return root;
    }


    public ArrayList<Integer> toArray(TreeNode node,ArrayList<Integer> arrL){

        if (node !=null){
            arrL.add(node.val);
            if (node.left!=null){
                toArray(node.left,arrL);
            }else{
                arrL.add(null);
            }
            if (node.right!=null){
                toArray(node.right,arrL);
            }else{
                arrL.add(null);
            }

        }
        return  arrL;
    }
    public ArrayList<Integer> toArrayLevelBylevel(TreeNode node,ArrayList<Integer> arrL){

        if (node !=null){
            arrL.add(node.val);
            toArray(node.left,arrL);
            toArray(node.right,arrL);

        }
        return  arrL;
    }

    public void insert(TreeNode root, int val) {
        TreeNode pointer = root;
        boolean posFound = false;
        while (!posFound) {
            if (pointer.val > val) {
                if (pointer.left == null) {
                    pointer.left = new TreeNode(val);
                    posFound = true;
                } else {
                    pointer = pointer.left;
                }
            } else {
                if (pointer.right == null) {
                    pointer.right = new TreeNode(val);
                    posFound = true;
                } else {
                    pointer = pointer.right;
                }

            }

        }
    }
}
