package logical_calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OperationOr extends Operation {
    @Override
    protected String getType() {
        return "OperationOr";
    }


    protected Variable exec(Variable left, Variable right) {
        String leftValue = ((Variable) left).getName();
        String rightValue = ((Variable) right).getName();

        String ans;

        if (leftValue.equals("1") || rightValue.equals("1"))
            ans = "1";
        else if (leftValue.equals("0") && rightValue.equals("0"))
            ans = "0";
        else if (leftValue.equals("0"))
            ans = rightValue;
        else if (rightValue.equals("0"))
            ans = leftValue;
        else if (leftValue.equals(rightValue))
            ans = ((Variable) right).getName();
        else {

            HashSet<String> store = new HashSet<>();
            store.add(leftValue);
            store.add(rightValue);
            ans = OperationAnd.mergeStore(store);
        }

        return new Variable(ans);
    }

    protected int getPriority() {
        return 1;
    }
}
