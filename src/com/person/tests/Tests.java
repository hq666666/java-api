package com.person.tests;

import com.person.example.Auth;
import com.person.example.Example;
import com.person.example.Simple;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Tests {


    /**
     * java eight primitive type test：
     */
    @Test
    public void test() throws Exception  {
        /**
         * Boolean type:
         *      包含boolean类型，实现了序列化且有指定的序列版本号
         */
        //-----------field---------------

        //获取此包装类类型
        Class<Boolean> type = Boolean.TYPE;

        Boolean bol = new Boolean(true);
        //获取Boolean类的哈希值： true:1231    false:1237
        int i1 = bol.hashCode();//1231
        /**
         * key point:
         *      Byte type:
         *          文件传输，网络传输都是以byte为单位尽心传输
         */
        //-----------Byte field-------------------
        int bytes = Byte.BYTES;//1
        byte maxValue = Byte.MAX_VALUE;//127
        byte minValue = Byte.MIN_VALUE;//-128
        int size = Byte.SIZE;//8(表示：8bit)
        Class<Byte> type1 = Byte.TYPE;
        //----------functions-----------------
        
        //constructor(构造器)
        Byte b = new Byte("76");
        //-------static method------------
        
        //比较两个byte数值
        int compare = Byte.compare((byte)124, (byte)125);//-1

        //解码一个 string 返回Byte
        Byte decode = Byte.decode("98");//98
        //返回一个哈希值
        int hashCode = Byte.hashCode((byte)108);//108
        //解析字符串参数
        byte b2 = Byte.parseByte("109");//109
        /*
            解析字符串参数：
                    注意：不要超过Byte的区间范围：-128~127
                    parameter01： 表示要解析的字符串（整数）
                    parameter02： 表示要解析的字符串的基数（基数：指的是该字符串的进制形式,常用二进制或十进制）
         */
        byte b3 = Byte.parseByte("1010", 2);//10
        //将参数转换为int 无符号的转换
        int i = Byte.toUnsignedInt((byte) 88);//88
        /*
                返回一个 Byte对象持有指定的值提取 String
                        注意：不要超过Byte的区间范围：-128~127
                        parameter01： 表示要解析的字符串（整数）
                        parameter02： 表示要解析的字符串的基数（基数：指的是该字符串的进制形式,常用二进制或十进制）
         */
        Byte aByte = Byte.valueOf("10100", 2);//20
        //返回一个新的 String对象代表
        String s = Byte.toString((byte) 119);//119
        String s1 = b.toString();//76
        //获取该Byte对象的值；
        byte b1 = b.byteValue();//76
        //返回的值作为 int Byte扩大原始转换 （注意:byte的区间范围）
        Byte by2 = new Byte("119");
        int i2 = by2.intValue();//119
        /*
                 比较两个Byte数值：
                        规则：
                            大于0：表示大于参数
                            等于0：表示等于参数
                            小于0：表示小于参数
         */
        int i3 = b.compareTo(by2);//-43
        /**
         * Character type:
         *
         *          Character类封装了原始类型char在一个对象里，一个Character类型的对象包含一个char类型的字段（char数据类型占16位）
         */
        //------constructor---------
        Character cha = new Character('中');
        //----------field--------------
        int bytes01 = Character.BYTES;//2（byte）
        int size01 = Character.SIZE;//16(bit)
        int minRadix = Character.MIN_RADIX;
        int maxRadix = Character.MAX_RADIX;
        char maxValue01 = Character.MAX_VALUE;//65535 （int类型表现形式）
        char minValue01 = Character.MIN_VALUE;//0  （int类型表现形式）
        Class<Character> type01 = Character.TYPE;//char


    }

    @Test
    public void test02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /**
         * Class type:
         *
         *      01：Class类就是一个类关键在于这个Class类可以泛指一切（指的是会根据不同的类型，从而会生成不同的Class对象），
         *      02：
         *          实际上所有的类都是在对其第一次使用时动态加载到JVM中的，当程序创建第一个对类的静态成员引用时，就会加载这个被使用的类，
         *        注意：使用new操作符创建类的新实例对象也会被当作对类的静态成员的引用(构造函数也是类的静态方法)；
         *     03:reflect（发射机制）：
         *         注意点：
         *              forName方法(重点静态方法)：可以根据指定forName的形参(类名，完全限定名(包名+类名)),获取对应的class对象
         *
         *              Declared关键字：用于访问非public的 filed、constructor、method
         *
         *              setAccessible方法：主要运用于类的私有属性、构造器和方法
         *                          作用：
         *                              通过形参，决定是否需要进行java语言的检查；
         *             isInstance方法：表示形参是否属于该类的自子集；
         *
         *                形参：为Object类型(不是Class类型)
         *
         *
         *
         *
         *
         *
         *
         *
         */
        System.out.println(Example.class.toString());
        Example example = Example.class.newInstance();
        Field name = Example.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(example,"xiaoming");
        System.out.println(example.toString());
        Constructor<Example> constructor = Example.class.getConstructor(String.class, Integer.class);
        System.out.println(constructor.newInstance("hello",18));
        if(Example.class.isInstance(new Simple())) System.out.println("Class对象的isInstance方法与instanceOf关键字等价");
        //ThisTest thisTest = new ThisTest(18);
        System.out.println();
    }

    /**
     * reflex mechanism(反射机制)：
     *
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {

        String result = Example.class.toString();//class com.person.example.Example（数据类型+完全限定名）
        String result1 = Example.class.toGenericString();//public class com.person.example.Example （modifier(修饰符)+数据类型+完全限定名）

        //通过forName方法指定对应的类的完全限定名(包名+类名)获取指定类对象
        Class<?> forNameClass = Class.forName("com.person.example.Example");// 结果：class com.person.example.Example
        //通过newInstance可以获取该类对象的实例(默认使用null constructor（空构造器）)
        Example example = Example.class.newInstance();// com.person.example.Example@3c1
        //通过isInstance方法判定指定对象是否为该类对象的子集；
        boolean result3 = Object.class.isInstance(Example.class);// true
        //isAssignableFrom方法用来判断一个类Class1和另一个类Class2是否相同或是另一个类的超类或接口
        boolean result4 = Example.class.isAssignableFrom(Example.class);//true
        //通过getName方法获取类名
        String result5 = forNameClass.getName();//com.person.example.Example
        //通过getClassLoader方法获取该类对象的类加载器
        ClassLoader classLoader = Example.class.getClassLoader();//sun.misc.Launcher$AppClassLoader@18b4aac2
        //通过getTypeParameters方法获取该类对象定义的泛型变量的数组
        TypeVariable<Class<Example>>[] typeParameters = Example.class.getTypeParameters();
        for (TypeVariable<Class<Example>> type:typeParameters){
            System.out.println(type.toString());
        }
        //通过getSuperclass方法获取该类对象的父类
        Class<? super Example> superclass = Example.class.getSuperclass();//class java.lang.Object
        Type genericSuperclass = Example.class.getGenericSuperclass();//class java.lang.Object
        //通过getComponentType方法返回组件类型；
        Class<?> componentType = Example.class.getComponentType();//null
        //通过getModifiers方法获取该类对象修饰符的数量
        int modifiers = Example.class.getModifiers();//1
        //通过getSigners方法获取类签名
        //Object[] signers = Example.class.getSigners();
        String simpleName = Example.class.getSimpleName();//Example
        String typeName = Example.class.getTypeName();//com.person.example.Example
        /**
         * 通过getConstructorf方法获取指定的Constructor对象(可以指定参数，但是必须在元java程序中编写带参构造器)；
         * 通过getDeclaredConstructor方法获取指定非public的Constructor对象：
         *              注意：通过setAccessible方法设置跳过java语言检查；
         */
        Constructor<Example> constructor = Example.class.getConstructor(String.class, Integer.class);
        Example example1 = constructor.newInstance("xiaoming", 123);

        Constructor<Example> declaredConstructor = Example.class.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Example example2 = declaredConstructor.newInstance("xiaofang");
        //通过getAnnotation方法获取声明在该类的注解类
        Auth annotation = Example.class.getAnnotation(Auth.class);
        //D:\workspace\java-api\src\com\person\example\Example.java
        //通过getResource方法获取对应资源文件的路径形参(为文件名)
        URL resource = Example.class.getResource("/a.properties");
        //通过getResource方法获取对应资源文件的字节输入流形参(为文件名)
        InputStream resourceAsStream = Example.class.getResourceAsStream("/a.properties");

        byte[] bytes = new byte[20];
        //通过read方法获取文件的数据形参为接受多少字节数据；
        int read = resourceAsStream.read(bytes);
        System.out.println(read);
    }

    @Test
    public void test4(){
        /**
         * Integer API
         */
        //---------Field-------------
        int bytes = Integer.BYTES;// 4 （byte）
        int size = Integer.SIZE;//32(bit)
        int minValue = Integer.MIN_VALUE;// -2147483648
        int maxValue = Integer.MAX_VALUE;//2147483647

        //----------Method-------------

        //比较适用的几种方法
        int a =2;
        int b = 5;
        String s = "1234";
        int min = Integer.min(a, b);//2
        int max = Integer.max(a, b);//5
        int sum = Integer.sum(a, b);//7
        int i = Integer.parseInt(s);//1234
        Integer integer = Integer.valueOf(s);//1234
        long l = integer.longValue();//1234
        /**
         * BigDecimal:
         *          测试得出以下结论：
         *            常用的加减乘除运算方法：
         *                  add()、subtract()、multiply()、divide();
         *            注意：
         *
         *              01：除了divide(除法)内包含有设置精确到几位小数，其他几个方法都必须通过setScale方法进行设置；
         *              02：精确到几位小数，当前的BigDecimal数值超过你要保留的小数点位才会保留你要保留结果的小数点位数；
         *              03：四舍五入的方式，建议使用ROUND_HALF_UP；
         *
         */
        //----------BigDecimal------------
        BigDecimal test1 = new BigDecimal("7.000");
        BigDecimal test2 = new BigDecimal("3.0");
        BigDecimal scale = test1.setScale(2);
        Double result= test1.add(test2).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
       Double result1 = test1.subtract(test2).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
       Double result2 =test1.multiply(test2).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
       Double result3 =test1.divide(test2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(result+"\t"+result1+"\t"+result2+"\t"+result3+"\t"+scale);

        //----------Random-------------
        Random random = new Random();
        System.out.println(random);
        int i1 = (int) (Math.random() * 50+50);
        System.out.println(random.nextDouble()+51.0);
        System.out.println(random.nextBoolean());
        System.out.println(random.nextFloat());
        System.out.println(random.nextInt()+50);
        System.out.println(random.nextLong());
        System.out.println(random.nextInt(50)+50);
        System.out.println(i1);

    }

    @Test
    public void test5(){
        /**
         * String api:
         *
         *    概念：字符串是常量,字符串的对象是不可变对象
         */
        //声明字符串常量(注意常量是共享的)
          String var = "hello";
        //通过字符串字符串对象
        String varObj = new String("hello");
        //---------Field---------
        
        //获取String数据类型比较器对象
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        int order = comparator.compare("abc", "bc");// -1 (表示前者小于后者)

      //------------Mehtod--------------

      //---------static - method ----------------

       //通过copyValueOf方法 AND copyValueOf方法将字符数组转换为字符串(两个方法的区别：前者获取全部，后者可以选择性的截取)；
        char[] chars = new char[]{'a','p','p','l','e','i','s','r','e','d'};
        String copyVar = String.copyValueOf(chars);
        String copyVar2 = String.copyValueOf(chars,0,5);
        System.out.println(copyVar+"\r\n"+copyVar2);


        //通过format方法定义指定的格式将对象字符串格式化
        String date = String.format("%1$tY-%1$tm-%1$te %1$tH:%1$tM:%1$tS", new Date(System.currentTimeMillis()));
        String date1 = String.format(Locale.GERMANY, "%1$tY-%1$tm-%1$te %1$tH:%1$tM:%1$tS", new Date(System.currentTimeMillis()));

       //通过join方法可以将多个字符串或字符串集合/数组与自定的字符
        String[] strings = new String[]{"apple","banana","per"};
        String hello = String.join("-", "hello","java");//hello-java
        String stringArray = String.join("-", strings);//apple-banana-per

        //--------non-static-method------------------
        //通过compareTo和compareToIgnoreCase方法比较两个字符串按照原有的字符串顺序比大小(区别后者方法忽略大小写)
      int var1 =  varObj.compareTo("jkm");//-2
      int var2 = varObj.compareToIgnoreCase("ABCD");//7

      //通过concat方法进行字符串拼接，拼接的字符串在末尾处进行拼接
        String world = varObj.concat("world");//helloworld
        //通过contains方法表示该字符串对象是否包含此字符序列
        boolean he = varObj.contains("he");
        //通过contentEquals方法表示该字符串对象内容是否与该字符串一致；
        boolean llo = varObj.contentEquals("hello");
        //通过endsWith方法判断该字符串对象是否以形参内容为后缀
        boolean llo1 = varObj.endsWith("llo");
        //通过getBytes方法将该字符串对象转换成字节数组；
        byte[] bytes = varObj.getBytes();
        byte[] bytes1 = varObj.getBytes(StandardCharsets.UTF_8);

        //通过indexOf AND  lastIndexOf方法根据指定的字符返回该字符串对象第一次和最后一次出现的索引位置
        int l = varObj.indexOf("l");//2
        int l1 = varObj.lastIndexOf('l');//3


        boolean empty = varObj.isEmpty();
        String[] ls = varObj.split("l");


        //-------------StringBuffer------------------
        StringBuffer sb = new StringBuffer();
         for(int i =1;i<=10;i++){
             //通过append方法添加数值
             sb.append("concept"+i);
         }

         //通过reverse方法将该对象倒序排列
         sb.reverse();
        sb.insert(2,'h');
        System.out.println(sb);
    }

    /**
     * Base64加密解密
     */
    @Test
    public void test6(){

        String str = "helloWorld";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(str.getBytes());
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encode);
        String result = new String(decode);
        for (byte b : encode) {
            System.out.println(b);
        }
        String url = "http://localhost:8888/index";

        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        byte[] encode1 = urlEncoder.encode(url.getBytes());
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        byte[] decode1 = urlDecoder.decode(encode1);
        String resultUrl = new String(decode1);
        System.out.println(resultUrl);
    }
    @Test
    public  void test7(){



    }
}
