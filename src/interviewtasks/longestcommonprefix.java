package interviewtasks;

/**
 * leetcode.com 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 */
public class longestcommonprefix {
    // Brute force
    static class Solution {

        public String longestCommonPrefix(String[] strs) {
            if (strs.length==1){
                return strs[0];
            }
            StringBuilder prefix = new StringBuilder();

            int i=0;
            while (true){

                for (int k=1;k<strs.length;k++){
                    if (strs[k].length()==i|| (strs[k-1].length()==i|| strs[k].charAt(i)!=strs[k-1].charAt(i))){
                        return prefix.toString();

                    }
                }

                prefix.append(strs[1].charAt(i));
                i++;
            }

        }
    }

    public static void main(String[] args) {
        String helpMessage = "a strings is expected as a parameter e.g. \"feed,fear,feeble\" ";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        }
        String[] strings = args[0].split(",");

        System.out.println(new Solution().longestCommonPrefix(strings));
    }
}
