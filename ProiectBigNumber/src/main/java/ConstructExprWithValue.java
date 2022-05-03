import java.util.HashMap;
import java.util.Map;

public class ConstructExprWithValue {


    public static String constructExprWithValue(String expr, Map<String,String> keyValueExpr) {
        String exprWithValue = expr;
        String expSwap = "";
        for(String key : keyValueExpr.keySet()) {
            String value = keyValueExpr.get(key);
            expSwap=exprWithValue.replace(key, value);
            exprWithValue = expSwap;
        }
        return exprWithValue;
    }

}
