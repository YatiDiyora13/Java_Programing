package com.prominent.Threads;

class MyData
{
    synchronized public void display(String str)
    {

        for(int i=0;i<str.length();i++)
        {
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread1 extends Thread
{
    MyData d;

   public MyThread1(MyData d)
   {
       this.d = d;
   }
   public void run()
   {
       d.display("Hello world");
   }
}

class MyThread2 extends Thread
{
    MyData data;

    public MyThread2(MyData d)
    {
        data = d;
    }
    @Override
    public void run()
    {
        data.display("All Good");
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        MyData d = new MyData();
        MyThread1 t1 = new MyThread1(d);
        MyThread2 t2 = new MyThread2(d);

        t1.start();
        t2.start();
    }
}
