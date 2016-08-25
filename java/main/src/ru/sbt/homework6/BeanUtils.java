package ru.sbt.homework6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Work on 25.08.2016.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) {
        Method[] declaredMethodsFrom = from.getClass().getDeclaredMethods();
        Method[] declaredMethodsTo = to.getClass().getDeclaredMethods();

        for (int i = 0; i < declaredMethodsFrom.length; i++) {
            Method methodFrom = declaredMethodsFrom[i];
            String name = methodFrom.getName();
            if (name.startsWith("get")) {
                name = name.replaceFirst("get", "set");

                try {
                    Method methodTo = to.getClass().getMethod(name, methodFrom.getReturnType());
                    try {
                        methodTo.invoke(to, methodFrom.invoke(from, methodFrom.getParameterTypes()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
//                e.printStackTrace();
                    continue;
                }
            }

        }

    }
}
