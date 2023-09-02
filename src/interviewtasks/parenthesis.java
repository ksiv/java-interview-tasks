package interviewtasks;

import java.util.*;

public class parenthesis {
    static class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            List<Character> stack = new ArrayList<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) return false;
                    if (map.get(c) != stack.remove(stack.size() - 1)) return false;
                }
            }

            return stack.isEmpty();
        }

    }

    public static void main(String[] args) {
        String helpMessage = "one strings including parenthesis symbols is expected as a parameter e.g. \"[(){()}]\"";

        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        } else {
            System.out.println(new Solution().isValid(args[0]));
        }
    }
}