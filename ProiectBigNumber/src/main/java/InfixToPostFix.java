import java.util.Stack;

public class InfixToPostFix {

    static int precedence(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression) {

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] exp = expression.split(" ");
        int n = exp.length;

        for (String c : exp) {
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                    result.append(" ");
                }
                stack.push(c);
            } else if (c.equals(")")) {
                String x = stack.pop();
                while (!x.equals("(")) {
                    result.append(x);
                    result.append(" ");
                    x = stack.pop();
                }
            } else if (c.equals("(")) {
                stack.push(c);
            } else {
                result.append(c);
                result.append(" ");
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            result.append(stack.pop());
            result.append(" ");
        }
        return result.toString();
    }
}