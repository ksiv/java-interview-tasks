package interviewtasks;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode.com 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 */
public class longestsubstring {

    // Brut force
    public static int lengthOfLongestSubstring(String s) {
        int maxVal=0;
        for (int i=0;i<s.length();i++){
            int val =sub(s.substring(i,s.length()));
            if (maxVal<val) maxVal=val;
            if (s.length()-i<maxVal) break;

        }
        return maxVal;
    }
    public static int sub(String s){
        Set<Character> hs = new HashSet<>();
        int counter=0;
        int maxCounter=0;
        for (int i=0;i<s.length();i++){
            if(!hs.add(s.charAt(i))){
                if (counter>maxCounter) maxCounter=counter;
                counter=0;
            }
            counter++;
        }
        if (counter>maxCounter) maxCounter=counter;

        return maxCounter;
    }
    // sliding window
    public static  int lengthOfLongestSubstring2(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;

        for(int right=0;right<s.length();right++){

            if(!set.add(s.charAt(right))){

                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }else {
                maxLength=Math.max(maxLength,right-left+1);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        String helpMessage = "String \"abcabcx\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            System.out.println(lengthOfLongestSubstring(args[0]));
            System.out.println(lengthOfLongestSubstring2(args[0]));

        }

    }
}
