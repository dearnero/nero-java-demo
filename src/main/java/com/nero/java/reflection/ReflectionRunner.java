package com.nero.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 * date : 2019-02-27
 * time : 11:47
 * </p>
 *
 * @author Nero
 */
public class ReflectionRunner {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class studentClass = Class.forName("com.nero.java.reflection.Student");
        // 获取打印studentClass下所有公开方法以及其所有父类公开方法
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        Student student = (Student) studentClass.newInstance();
        // 调用公开方法
        Method publicMethod = studentClass.getDeclaredMethod("studentSayHello");
        publicMethod.invoke(student, null);
        // 调用私有方法
        Method privateMethod = studentClass.getDeclaredMethod("studentSayPrivate");
        // 如果没有如下设置，将出现异常：IllegalAccessException
        privateMethod.setAccessible(true);
        privateMethod.invoke(student, null);
    }
}
