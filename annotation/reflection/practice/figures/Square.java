package annotation.reflection.practice.figures;

import annotation.reflection.practice.tasks.MyAnno;

public class Square extends Shape {
    @Override
    @MyAnno(str = "My annotation in Square")
    public String toString() {
        return "Square";
    }
}

