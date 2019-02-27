package com.nero.java.reflection;

/**
 * <p>
 * date : 2019-02-27
 * time : 11:48
 * </p>
 *
 * @author Nero
 */
public class Student extends People {

    private String Sid;

    public void studentSayHello() {

        System.out.println("hello, i am student");
    }

    private void studentSayPrivate() {

        System.out.println("hello, i am private student");
    }
}
