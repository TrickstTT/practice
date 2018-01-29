package com.hehe.test;

public class TrySth {
    public static void main(String[] args) {
//        Two two = new Two();
//        Two two2 = new Two();
        new One();
        new One();

    }
}
class One{
    static{
        System.out.println("静态代码块");
    }

    One(){
        System.out.println("One is being instance");
    }
    {
        System.out.println("代码块");
    }
}
class Two{
    One one = null;
    Two(){
        if(one == null){
            new One();
        }
    }
}