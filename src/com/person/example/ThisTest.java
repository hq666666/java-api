package com.person.example;

/**
 * this keyword 使用测试：
 *      总结：
 *          01：this表示对当前对象的引用；
 *          02：在static修饰的方法不能使用this（原因：静态常量早于对象被先在加载于内存中）；
 *          03：在constructor调用其他的construtor必须位于第一位，且只能调用一次；
 *          04：同名变量时，可以使用this区别成员变量与局部变量；
 */
public  class ThisTest {

    private static int age;

    private String  name;
    public ThisTest(){

    }
    public ThisTest(int age){
        this.age=age+1;
        System.out.println("形参："+age+"类的成员变量："+this.age);
    }

    public ThisTest(int age,String name ){
        this(age);
        this.name = name;
        System.out.println("年龄："+age+"姓名："+name);
    }


}
