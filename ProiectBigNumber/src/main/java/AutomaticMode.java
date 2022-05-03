public class AutomaticMode {

    public static void main(String[] args) {

        ParseXMLDocument.parseFileXML("input.xml");
        String expXML = ConstructExprWithValue.constructExprWithValue(ParseXMLDocument.expr, ParseXMLDocument.keyValueExp);
        System.out.println(expXML);

        System.out.println("Infix Expression: " + expXML);
        System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(expXML));

        try {
            String postFixExp = InfixToPostFix.infixToPostFix(expXML);
            System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp));
            System.out.println(PostfixEvaluation.evaluationSteps);

            ResultInXMLFile.createXMLFileWithSteps(expXML, PostfixEvaluation.evaluationSteps, PostfixEvaluation.evaluatePostfix(postFixExp));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ResultInXMLFile.createXMLFileWithError(expXML,e.getMessage());
        }

    }
}
