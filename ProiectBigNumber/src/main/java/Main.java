public class Main {

    public static void main(String[] args) {
        String exp = "9 ^ 2 + ( 2 + 5 ) + 5 * 3";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(exp));

        String postFixExp = InfixToPostFix.infixToPostFix(exp);
        System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp));
        System.out.println(PostfixEvaluation.evaluationSteps);

        ParseXMLDocument doc = new ParseXMLDocument("class.xml");
        doc.parseFileXML();
        ConstructExprWithValue constructExprWithValueObject = new ConstructExprWithValue(doc.getExpr(), doc.getKeyValueExp());
        String expXML = constructExprWithValueObject.constructExprWithValue();
        System.out.println(expXML);

        System.out.println("Infix Expression: " + expXML);
        System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(expXML));

        String postFixExp1 = InfixToPostFix.infixToPostFix(expXML);
        System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp1));
    }
}
