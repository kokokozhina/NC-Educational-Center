package annotation.reflection.practice.tasks;

import java.util.ArrayDeque;
import java.util.Arrays;

import annotation.reflection.practice.figures.Square;

public class PredecessorsAndMethods {

    /**
     * Prints all methods that belongs to the class of specified object and
     * its predecessors.
     */
    public static void printPredecessorsWithMethods(Object obj) throws ClassNotFoundException {
        if (obj.equals(null)) {
            return;
        }

        Class ex = obj.getClass();

        while (true) {
            System.out.println(ex.getCanonicalName() + ": " + Arrays.asList(ex.getDeclaredMethods()));

            if (ex.getName().equals(Object.class.getName())) {
                return;
            }

            ex = ex.getSuperclass();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("An example with an instance of Square class");
        printPredecessorsWithMethods(new Square());

        System.out.println("\nAn example with an instance of ArrayDeque class");
        printPredecessorsWithMethods(new ArrayDeque<Integer>());
    }
}
