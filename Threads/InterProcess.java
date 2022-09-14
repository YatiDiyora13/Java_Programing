package com.prominent.Threads;

class MyInterData
{
    int value;
    boolean flag = true;
    synchronized  public void set(int v)
    {
        while (flag !=true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = v;
        flag = false;
        notify();
    }
    synchronized public int get()
    {
        int x=0;
        while (flag !=false) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        x=value;
        flag = true;
        notify();
        return x;
    }
}

class Producer extends Thread
{
    MyInterData data;
    public Producer(MyInterData d)
    {
        data = d;
    }
    @Override
    public void run()
    {
        int count = 1;
        while (true)
        {
            data.set(count);
            System.out.println("Producer"+count);
            count++;
        }
    }

}
class Consumer extends Thread
{
    MyInterData data;
    public Consumer(MyInterData d)
    {
        data = d;
    }
    public void run()
    {
        int value;
        while (true)
        {
            value = data.get();
            System.out.println("consumer"+value);
        }
    }

}

public class InterProcess {
    public static void main(String[] args) {

        MyInterData data = new MyInterData();
        Producer p = new Producer(data);
        Consumer c = new Consumer(data);
        p.start();
        c.start();
    }
}
