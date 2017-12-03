package logical_calculator;

import java.util.*;
import java.util.regex.Pattern;

public class OperationAnd extends Operation {
    @Override
    protected String getType() {
        return "OperationAnd";
    }

    protected static String mergeStore(HashSet<String> store) {
        StringBuilder ans = new StringBuilder();
        boolean foundAll = false;
        HashSet<String> splitStore = new HashSet<>();
        for (String storeX : store) {
            String[] splitStX = storeX.split(Pattern.quote("|"));
            splitStore.addAll(Arrays.asList(splitStX));
        }

        for (String storeX : splitStore) {
            if (storeX == "0")
                continue;
            if (storeX == "1")
                return "1";
            foundAll = true;
            String[] noXsplit = (OperationNo.exec(new Variable(storeX)).getName()).split(Pattern.quote("|"));


            for (int i = 0; i < noXsplit.length; i++) {

                if (!splitStore.contains(noXsplit[i])) {
                    foundAll = false;
                    break;
                }
            }

            if (foundAll)
                break;
            else
                ans.append(storeX + "|");
        }
        if (foundAll)
            return "1";
        else {
            if (ans.length() > 0)
                ans.deleteCharAt(ans.length() - 1);
            return ans.toString();
        }
    }

    protected Variable exec(Variable left, Variable right) {
        String leftValue = ((Variable) left).getName();
        String rightValue = ((Variable) right).getName();

        String ans;

        if (leftValue.equals("0") || rightValue.equals("0"))
            ans = "0";
        else if (leftValue.equals("1") && rightValue.equals("1"))
            ans = "1";
        else if (leftValue.equals("1"))
            ans = rightValue;
        else if (rightValue.equals("1"))
            ans = leftValue;
        else if (leftValue.equals(rightValue))
            ans = ((Variable) right).getName();
        else {

            HashSet<String> store = new HashSet<>();

            String[] leftSplit = leftValue.split(Pattern.quote("|"));
            String[] rightSplit = rightValue.split(Pattern.quote("|"));
            for (int i = 0; i < leftSplit.length; i++) {

                String[] liSplit = leftSplit[i].split(Pattern.quote("&"));


                for (int j = 0; j < rightSplit.length; j++) { //неправильно
                    TreeSet<String> buf = new TreeSet<>(Arrays.asList(liSplit));
                    String[] rjSplit = rightSplit[j].split(Pattern.quote("&"));
                    boolean f = false;
                    for (int z = 0; z < rjSplit.length; z++) {
                        String cur = rjSplit[z];
                        if (!buf.contains((OperationNo.exec(new Variable(cur))).getName())) {
                            buf.add(cur);
                        } else {
                            f = true;
                            break;
                        }
                    }

                    if (!f) {
                        StringBuilder accum = new StringBuilder();
                        for (String bufX : buf)
                            accum.append(bufX + "&");
                        if (!buf.isEmpty())
                            accum.deleteCharAt(accum.length() - 1);
                        store.add(accum.toString());
                    } else
                        store.add("0");
                }
            }

            ans = mergeStore(store);


        }

        return new Variable(ans);
    }

    protected int getPriority() {
        return 2;
    }

}
