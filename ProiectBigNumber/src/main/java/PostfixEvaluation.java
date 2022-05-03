import java.util.*;

public class PostfixEvaluation
{

    public static String evaluationSteps = "";

    static boolean isOperator(String operator)
    {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^");
    }

    static String buildExpression(String operator, String op1, String op2, String result){
       return op1 + " " + operator + " " + op2 + " = " + result +  "\n";
    }

    static BigNumber evaluatePostfix(String expression)
    {
        StringBuilder steps = new StringBuilder();
        String[] exp = expression.split(" ");
        Stack<BigNumber> postFix = new Stack<>();
        int n = exp.length;

        for(int i=0;i<n;i++)
        {
            if(isOperator(exp[i]))
            {
                BigNumber op1 = postFix.pop();
                BigNumber op2 = postFix.pop();
                BigNumber result;

                switch(exp[i])
                {
                    case "+":
                        result = new BigNumber(BigNumber.add(op1.getValue(), op2.getValue()));
                        postFix.push(result);
                        steps.append(buildExpression("+", op1.getValue(), op2.getValue(), result.getValue()));
                        break;

                    case "-":
                        result = new BigNumber(BigNumber.substract(op2.getValue(), op1.getValue()));
                        postFix.push(result);
                        steps.append(buildExpression("-", op2.getValue(), op1.getValue(), result.getValue()));
                        break;

                    case "*":
                        result = new BigNumber(BigNumber.multiply(op1.getValue(), op2.getValue()));
                        postFix.push(result);
                        steps.append(buildExpression("*", op1.getValue(), op2.getValue(), result.getValue()));
                        break;

                    case "/":
                        result = new BigNumber(BigNumber.divide(op2.getValue(), Integer.parseInt(op1.getValue())));
                        postFix.push(result);
                        steps.append(buildExpression("/", op2.getValue(), op1.getValue(), result.getValue()));
                        break;

                    case "^":
                        result = new BigNumber(BigNumber.power(op2.getValue(), Long.parseLong(op1.getValue())));
                        postFix.push(result);
                        steps.append(buildExpression("^", op2.getValue(), op1.getValue(), result.getValue()));
                        break;
                }

            }

            else
            {

                BigNumber operand = new BigNumber(exp[i]);
                postFix.push(operand);
            }
        }
        evaluationSteps = steps.toString();
        return postFix.pop();
    }
}