package logical_calculator;

public class Operation extends Object{
    @Override
    protected String getType() {
        return "Operation";
    }

    @Override
    protected boolean isOperation() {
        return true;
    }

    @Override
    protected int getPriority() {
        System.out.println("ERROR IN OPERATION");
        throw new IllegalArgumentException();
    }

    protected Variable exec(Variable l, Variable r) {
        System.out.println("ERROR IN OPERATION");
        throw new IllegalArgumentException();
    };


}
