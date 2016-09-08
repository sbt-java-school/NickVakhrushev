package ru.sbt.homework5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        showMethods(Person.class);
    }

    static void showMethods(Class p_class) {
        Field[] declaredFields = p_class.getDeclaredFields();

        for (Field field : declaredFields
                ) {
            System.out.print("Name = " + field.getName() + " type=" + field.getType());
            System.out.println("");
        }

        Method[] declaredMethods = p_class.getDeclaredMethods();
        for (Method method : declaredMethods
                ) {
            System.out.println(method.getName());

            Parameter[] parameters = method.getParameters();
            if (parameters.length > 0) {
                System.out.println("\tParameters:");

                for (Parameter parameter : parameters
                        ) {
                    System.out.print("\t" + parameter.getName());
                    System.out.print("\t" + parameter.getType());

                }

                System.out.println("");
            }

            int modifiers = method.getModifiers();
            System.out.println("\tThis method is: ");

            System.out.print(Modifier.isStatic(modifiers) ? "\t\tstatic " : "");
            System.out.print(Modifier.isPrivate(modifiers) ? "\t\tprivate " : "");
            System.out.print(Modifier.isPublic(modifiers) ? "\t\tpublic " : "");
            System.out.print(Modifier.isProtected(modifiers) ? "\t\tprotected " : "");

            System.out.println("");
        }
    }
}
