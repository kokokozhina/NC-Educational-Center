Hello!

This package contains logical calculator based on 3 logical operations:
1. '|' - OR
2. '&' - AND
3. '~' - NO

You also can use '(', ')'. Any other symbols would be interpreted like variable's name.
Currently you can use '\~' only before the variable ('\~X', but not '\~(X)' neither '\~(X | Y)').
Please, check expression thoroughly - there is no control of expression's correctness. Some test examples could be found into logical_expression/tests.txt with answers after double slash.

To use this program you should type required expression into logical_expression.Main.main
(logical_expression/Main.java:5).

CURRENT UNRESOLVED PROBLEMS:
1. Using '~' before '('.
2. Lack of validation.
3. Poor clipping ("A|A&B&C|A&C" when "A" is available).

Any feedback is welcome!
 
