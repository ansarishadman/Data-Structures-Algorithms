package LeetCode.Strings;

import java.util.Stack;
public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        // Odd length strings can never be balanced
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                // If stack is empty when seeing a closing bracket, it's invalid
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((c == ']' && top == '[') ||
                        (c == '}' && top == '{') ||
                        (c == ')' && top == '(')) {
                    stack.pop();
                } else {
                    // Unmatched closing bracket -> return false immediately!
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC20_ValidParentheses solver = new LC20_ValidParentheses();

        // Test Cases
        System.out.println("Test 1: " + solver.isValid("()[]{}")); // Expected: true
        System.out.println("Test 2: " + solver.isValid("(]"));     // Expected: false
        System.out.println("Test 3: " + solver.isValid("([)]"));   // Expected: false
    }
}