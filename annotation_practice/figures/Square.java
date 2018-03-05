package annotation_practice.figures;

import annotation_practice.tasks.MyAnno;

public class Square extends Shape {
    @Override
    @MyAnno(str = "My annotation in Square")
    public String toString() {
        return "Square";
    }
}

