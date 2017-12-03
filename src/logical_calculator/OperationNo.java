package logical_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OperationNo extends Operation {
    @Override
    protected String getType() {
        return "OperationNo";
    }

    static Variable exec(Variable r) { //в выражении могут быть только &
        StringBuilder ans = new StringBuilder();
        String[] rSplit = r.getName().split(Pattern.quote("&"));
        for (int i = 0; i < rSplit.length; i++) {
            String cur = rSplit[i];
            if(cur.charAt(0) == '~')
                ans.append(cur.substring(1));
            else {
                ans.append('~');
                ans.append(cur);
            }
            if(i < rSplit.length - 1)
                ans.append('|');
        }

        return new Variable(ans.toString());
    }

    protected int getPriority() {
        return 3;
    }
}
