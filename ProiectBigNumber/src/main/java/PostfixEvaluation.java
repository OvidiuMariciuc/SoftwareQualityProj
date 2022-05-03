import java.util.*;

public class PostfixEvaluation
{

    static boolean isOperator(String operator)
    {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^");
    }

    static BigNumber evaluatePostfix(String expression)
    {
        String[] exp = expression.split(" ");
        Stack<BigNumber> postFix = new Stack<>();
        int n = exp.length;

        for(int i=0;i<n;i++)
        {
            if(isOperator(exp[i]))
            {
                BigNumber op1 = postFix.pop();
                BigNumber op2 = postFix.pop();

                switch(exp[i])
                {
                    case "+": postFix.push(new BigNumber(BigNumber.add(op1.getValue(), op2.getValue())));
                        break;

                    case "-": postFix.push(new BigNumber(BigNumber.substract(op2.getValue(), op1.getValue())));
                        break;

                    case "*": postFix.push(new BigNumber(BigNumber.multiply(op1.getValue(), op2.getValue())));
                        break;

                    case "/": postFix.push(new BigNumber(BigNumber.divide(op2.getValue(), Integer.parseInt(op1.getValue()))));
                        break;

                    case "^": postFix.push(new BigNumber(BigNumber.power(op2.getValue(), Long.parseLong(op1.getValue()))));
                        break;
                }

            }

            else
            {
//                int operand = Integer.parseInt(exp[i]);
                BigNumber operand = new BigNumber(exp[i]);
                postFix.push(operand);
            }
        }

        return postFix.pop();
    }
}