import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // Tracks the sign/operation before the current number
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);

            // Build the multi-digit number
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // If the character is an operator or we reached the end of the string
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == length - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                // Reset to next operation and clear current number
                operation = currentChar;
                currentNumber = 0;
            }
        }

        // Sum up all elements left in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
