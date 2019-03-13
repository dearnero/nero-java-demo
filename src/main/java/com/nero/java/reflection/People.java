package com.nero.java.reflection;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * date : 2019-02-27
 * time : 11:48
 * </p>
 *
 * @author Nero
 */
public class People {

    private String name;

    public void peopleSayHello() {

        System.out.println("hello, i am People");
        Integer a = 1;
    }

    private void peopleSayHelloPrivate() {

        System.out.println("hello, i am private People");
    }
}
