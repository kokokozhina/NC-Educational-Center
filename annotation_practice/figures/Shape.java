package annotation_practice.figures;

import annotation_practice.tasks.MyAnno;

abstract public class Shape {
    @MyAnno(str = "My annotation in Shape")
    public void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}
