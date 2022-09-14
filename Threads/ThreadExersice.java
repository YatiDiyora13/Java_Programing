package com.prominent;
import java.lang.Thread;



class ThreadControler
{
    public boolean flag = true;
    synchronized public void even()
    {
        while (flag!=true)
        {
            try {
                wait();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag = false;
        notify();
    }
    synchronized public void odd()
    {
        while (flag!=false)
        {
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag = true;
        notify();
    }
}

class OddNumber extends Thread
{
    ThreadControler tc;
    public OddNumber(ThreadControler t){tc =t;}

    public void run()
    {

        for(int i=0;i<1000;i++)
        {
            if((i+1)%2!=0)
            {
                tc.odd();
                System.out.println(i);
            }
        }
    }
}

class EvenNumber implements Runnable
{
    ThreadControler tc;
    public EvenNumber(ThreadControler t){tc=t;}

 public void run()
 {
     for(int i=0;i<1000;i++)
     {
         if((i+1)%2==0)
         {
             tc.even();
             System.out.println(i);
         }

     }
 }
}

class DiviserMain
{
    int maxDivisors = 1;
    int numWithMax = 1;
    public void divaiser() {
        for (int i = 2; i < 10000; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > maxDivisors) {
                maxDivisors = count;
                numWithMax = i;
            }
        }
        System.out.println("The number of "+numWithMax+" has the "+maxDivisors+" divisors");
    }
}
class NumDivaiser extends Thread
{
    DiviserMain dm;
    public NumDivaiser(DiviserMain d){dm=d;}
    public void run()
    {
        dm.divaiser();

    }
}


public class ThreadExersice {
    public static void main(String[] args) {
//        ThreadControler tc = new ThreadControler();
//        OddNumber o = new OddNumber(tc);
//        EvenNumber e = new EvenNumber(tc);
//        Thread t = new Thread(e);
//        o.start();
//        t.start();

        DiviserMain dm = new DiviserMain();
        NumDivaiser d = new NumDivaiser(dm);
        d.start();

    }
}
