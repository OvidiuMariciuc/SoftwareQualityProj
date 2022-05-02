public class Main {

    public static void main(String[] args) {
        String exp = "1 + ( 100000000000 * 9999 ) + 3 * 9 ";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(exp));

        String postFixExp = InfixToPostFix.infixToPostFix(exp);
        System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp));
    }
}
