package logical_calculator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PolishPostfixNotation {

    protected static ArrayList<Object> parse(String s)
    {
        ArrayList<Object> objects = new ArrayList<>();
        StringBuilder aux = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c) {
                case '(' :
                    objects.add(new LeftBracket());
                    break;
                case ')' :
                    objects.add(new RightBracket());
                    break;
                case '|' :
                    objects.add(new OperationOr());
                    break;
                case '&' :
                    objects.add(new OperationAnd());
                    break;
                case ' ' :
                    break;
                case '~' :
                    objects.add(new OperationNo());
                    break;
                default:
                    aux = new StringBuilder();
                    for (; i < s.length(); i++) {
                        c = s.charAt(i);
                        if(c == '(' || c == ')' || c == '|'
                                || c == '&' || c == ' ' || c == '~')
                            break;
                        else
                            aux.append(c);
                    }
                    i--;
                    objects.add(new Variable(aux.toString()));
                    break;
            }
        }


        return objects;
    }

    private static void exec(Stack<Variable> vars, Object op) {
        Variable r = vars.peek();
        vars.pop();
        Variable newVar;

        if(op.getType() == "OperationNo") {
            OperationNo opNo = (OperationNo) op;
            newVar = opNo.exec(r);
        }
        else {
            Variable l = vars.peek();
            vars.pop();

            Operation opLegit = (Operation) op;
            newVar = opLegit.exec(l, r);
        }

        vars.push(newVar);

    }

    protected static String execPPN(String s) {
        ArrayList<Object> parsedS = parse(s);
        StringBuilder ans = new StringBuilder();
        Stack<Variable> vars = new Stack<>();
        Stack<Object> ops = new Stack<>();

        parsedS.add(0, new LeftBracket());
        parsedS.add(parsedS.size(), new RightBracket());

        for(int i = 0; i < parsedS.size(); i++) {
            if(parsedS.get(i).getType() == "LeftBracket") {
                ops.push(parsedS.get(i));
            }
            else if(parsedS.get(i).getType() == "RightBracket") {
                while(ops.peek().getType() != "LeftBracket") {
                    exec(vars, ops.peek());
                    ops.pop();
                }

                ops.pop();
            }
            else if(parsedS.get(i).isOperation()) {
                Operation curOp = (Operation) parsedS.get(i);
                while(!ops.empty() &&  ops.peek().getPriority() >= curOp.getPriority()) {
                    exec(vars, ops.peek());
                    ops.pop();
                }
                ops.push(curOp);
            }
            else {
                vars.push((Variable) parsedS.get(i));
            }

        }
        return vars.peek().getName();
    }

}
