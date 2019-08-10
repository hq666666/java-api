package com.person.tests;

import org.junit.Test;

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
    public void test02(){
        /**
         * Class
         */
    }
}
