public class Main {

    public static void main(String[] args) {
        String exp = "1000000 + 999978 - ( 999978 + 1000000 )";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(exp));

        String postFixExp = InfixToPostFix.infixToPostFix(exp);
        System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp));
    }
}
