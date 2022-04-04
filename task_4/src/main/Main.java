package main;

import annotations.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            ExampleClass example = new ExampleClass();

            Class<?> c = example.getClass();
            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(MyAnnotation.class)) {
                    m.setAccessible(true);
                    int callNum = m.getAnnotation(MyAnnotation.class).callNum();
                    for (int i = 0; i < callNum; ++i)
                        m.invoke(example);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
