package main;

import annotations.MyAnnotation;

public class ExampleClass {
    static int counter = 0;

    @MyAnnotation(callNum = 4)
    private void foo() {
        System.out.println("foo method[" + ++counter +"]");
    }

    @MyAnnotation(callNum = 3)
    private void bar() {
        System.out.println("bar method[" + ++counter + "]");
    }

    @MyAnnotation(callNum = 2)
    private void baz() {
        System.out.println("baz method[" + ++counter +"]");
    }

    @MyAnnotation(callNum = 1)
    private void qux() {
        System.out.println("qux method[" + ++counter +"]");
    }
}
