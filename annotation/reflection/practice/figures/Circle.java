package annotation.reflection.practice.figures;

import annotation.reflection.practice.tasks.MyAnno;

public class Circle extends Shape {
    @Override
    @MyAnno(str = "My annotation in Circle")
    public String toString() {
        return "Circle";
    }
}
