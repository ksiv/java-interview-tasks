package interviewtasks;
import interviewtasks.lib.bst;

import java.util.ArrayList;


/**
 * leetcode.com 100. Same Tree
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 */
public class treeissametree {

    // non memory optimal approach
    public boolean isSameTree(bst.TreeNode p, bst.TreeNode q) {
        ArrayList al1 = toArray(p,new ArrayList<Integer>());
        ArrayList al2 = toArray(q,new ArrayList<Integer>());
        return al1.equals(al2);
    }
    public ArrayList<Integer> toArray(bst.TreeNode node,ArrayList<Integer> arrL){

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

    public static void main(String[] args) {
        String helpMessage = "Two Comma separated int arrays without duplicates \"4,2,7,1,3,6,9\" \"4,2,7,1,3,6,8\" is expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            String[] stringArray2 = args[1].split(",");
            int[] intArray2 = new int[stringArray2.length];
            for (int i = 0; i < stringArray2.length; i++) {
                intArray2[i] = Integer.parseInt(stringArray2[i]);
            }

            bst tree1 = new bst();
            bst tree2 = new bst();

            tree1.root = tree1.buildFromAnArray(intArray);
            tree2.root = tree2.buildFromAnArray(intArray2);
            System.out.println(tree1.root.toString());
            System.out.println(tree2.root.toString());


            System.out.println(new treeissametree().isSameTree(tree1.root,tree2.root));

        }
    }
}
