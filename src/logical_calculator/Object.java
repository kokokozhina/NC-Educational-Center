package logical_calculator;

public abstract class Object {

    protected String type;

    abstract protected String getType();

    protected boolean isOperation() {
        return false;
    }

    protected int getPriority() {
        return 0;
    };

}
