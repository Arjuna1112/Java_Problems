package com.multithreading.concurrencyimpl;

public class Test extends Thread{
    public static void main(String args[]){
        Test test = new Test();
        test.start();
    }
    @Override
    public void run(){
        System.out.println("Hello");
    }
}

class Test1 implements Runnable{
    public static void main(String args[]){
        float f1 = -0.1f;
        System.out.println(f1);
        Test1 test = new Test1();
        Thread t = new Thread(test);
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Hi");
    }
}