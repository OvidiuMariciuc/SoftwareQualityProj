import java.util.HashMap;
import java.util.Map;

public class ConstructExprWithValue {
    private String expr;
    private Map<String,String> keyValueExpr = new HashMap<>();
    public ConstructExprWithValue(String expr, Map<String,String> keyValueExpr) {
        this.expr = expr;
        this.keyValueExpr = keyValueExpr;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Map<String, String> getKeyValueExpr() {
        return keyValueExpr;
    }

    public void setKeyValueExpr(Map<String, String> keyValueExpr) {
        this.keyValueExpr = keyValueExpr;
    }
    public String constructExprWithValue() {
        String exprWithValue = this.expr;
        String expSwap = "";
        for(String key : this.keyValueExpr.keySet()) {
            String value = this.keyValueExpr.get(key);
            expSwap=exprWithValue.replace(key, value);
            exprWithValue = expSwap;
        }
        return exprWithValue;
    }
}
