package annotation_practice.figures;

import annotation_practice.tasks.MyAnno;

public class Circle extends Shape {
    @Override
    @MyAnno(str = "My annotation in Circle")
    public String toString() {
        return "Circle";
    }
}
