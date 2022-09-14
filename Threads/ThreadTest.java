package com.prominent.Threads;

class MyThread implements Runnable
{
    @Override
    public void run()
    {
        int i =1;
        while (true)
        {
            System.out.println(i+" Hello");
            i++;
        }
    }
}


public class ThreadTest{


    public static void main(String[] args) {
        MyThread m = new MyThread();
        Thread t = new Thread(m);
        t.start();
        int j = 1;
        while (true)
        {
            System.out.println(j+" world");
            j++;
        }
    }
}
