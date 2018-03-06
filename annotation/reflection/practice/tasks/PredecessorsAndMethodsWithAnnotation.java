package annotation.reflection.practice.tasks;

import java.lang.reflect.Method;
import java.util.ArrayDeque;

import annotation.reflection.practice.figures.Square;

public class PredecessorsAndMethodsWithAnnotation {

    /**
     * Prints all methods that belongs to the class of specified object and
     * its predecessors. If method has a special annotation, puts '*' before
     * method description.
     */
    public static void printPredecessorsWithMethodsAndCheckAnnotation(Object obj) throws ClassNotFoundException {
        if (obj.equals(null)) {
            return;
        }

        Class ex = obj.getClass();

        while (true) {
            System.out.println(ex.getCanonicalName() + ": [");
            Method[] declaredMethods = ex.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(MyAnno.class)) {
                    System.out.println("* " + method.toString());
                } else {
                    System.out.println(method.toString());
                }
            }
            System.out.println("]");

            if (ex.getName().equals(Object.class.getName())) {
                return;
            }

            ex = ex.getSuperclass();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("An example with an instance of Square class");
        printPredecessorsWithMethodsAndCheckAnnotation(new Square());

        System.out.println("\nAn example with an instance of ArrayDeque class");
        printPredecessorsWithMethodsAndCheckAnnotation(new ArrayDeque<Integer>());
    }
}
