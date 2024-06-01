package br.com.biblioteca;

import java.lang.reflect.Method;

public class LogUtil {
    public static void logMethodCall(Object obj, String methodName, Object... params) {
        try {
            Method method = obj.getClass().getMethod(methodName, new Class<?>[params.length]);
            System.out.println("Chamando método: " + methodName + " da classe: " + obj.getClass().getName());
            for (Object param : params) {
                System.out.println("Parâmetro: " + param);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

