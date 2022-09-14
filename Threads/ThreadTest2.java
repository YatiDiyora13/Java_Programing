package com.prominent.Threads;

class MyThred extends Thread
{

    public void run()
    {
        int i=1;
        while (true)
        {
            System.out.println(i++ + "Thread My");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e) ;
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String []args) throws Exception{
        MyThred t = new MyThred();
        t.start();

        int count = 1;
        while (true)
        {
            System.out.println(count++ +"main");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e) ;
            }
            Thread.yield();
        }



    }
}
