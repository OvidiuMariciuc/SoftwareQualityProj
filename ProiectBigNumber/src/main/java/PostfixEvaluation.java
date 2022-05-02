import java.util.*;

public class PostfixEvaluation
{

    static boolean isOperator(String operator)
    {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^");
    }

    static int evaluatePostfix(String expression)
    {
        String[] exp = expression.split(" ");
        Stack<Integer> postFix = new Stack<>();
        int n = exp.length;

        for(int i=0;i<n;i++)
        {
            if(isOperator(exp[i]))
            {
                int op1 = postFix.pop();
                int op2 = postFix.pop();

                switch(exp[i])
                {
                    case "+": postFix.push(op2 + op1);
                        break;

                    case "-": postFix.push(op2 - op1);
                        break;

                    case "*": postFix.push(op2 * op1);
                        break;

                    case "/": postFix.push(op2 / op1);
                        break;

                    case "^": postFix.push(op2 ^ op1);
                       // not working yet
                        break;
                }

            }

            else
            {
                int operand = Integer.parseInt(exp[i]);
                postFix.push(operand);
            }
        }

        return postFix.pop();
    }
}