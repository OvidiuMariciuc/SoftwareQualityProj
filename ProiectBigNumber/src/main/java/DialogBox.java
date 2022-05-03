import javax.swing.*;

public class DialogBox {
    public static void main(String[] args) {
        JTextField xField = new JTextField(40);

        Object[] options1 = {"Evaluate expression", "Cancel"};

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Please Enter expression: "));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer

        int result = JOptionPane.showOptionDialog(null, myPanel, "ExpressionEvaluatorBox",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        if (result == JOptionPane.YES_OPTION) {
            String exp = xField.getText();
            System.out.println("Infix Expression: " + exp);
            System.out.println("Postfix Expression: " + InfixToPostFix.infixToPostFix(exp));

            String postFixExp = InfixToPostFix.infixToPostFix(exp);
            System.out.println(PostfixEvaluation.evaluatePostfix(postFixExp));
            JOptionPane.showMessageDialog(null,
                    "Result of the evaluation = " + PostfixEvaluation.evaluatePostfix(postFixExp),
                    "ResultBox", JOptionPane.INFORMATION_MESSAGE);
        }

//        System.out.println();
    }
}
