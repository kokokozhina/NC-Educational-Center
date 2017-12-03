package logical_calculator;

import java.util.ArrayList;

public class Variable extends Object {
    protected String name;

    @Override
    protected String getType() {
        return "Variable";
    }

    protected String getName()
    {
        return name;
    }


    Variable(String name)
    {
        this.name = name;
    }
}
