package annotation.reflection.practice.figures;

import annotation.reflection.practice.tasks.MyAnno;

abstract public class Shape {
    @MyAnno(str = "My annotation in Shape")
    public void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}
