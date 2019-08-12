package com.person.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * genericity(泛型)：
 */
public class GenericityTest {

    @Test
    public void test() {

        List<String> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        Class<? extends List> aClass = list.getClass();
        Class<? extends List> aClass1 = integers.getClass();
        if (aClass.equals(aClass1)) System.out.println("泛型只适用于编译时期");
    }

}
