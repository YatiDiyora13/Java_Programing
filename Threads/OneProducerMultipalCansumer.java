package com.prominent.Threads;

class Teacher extends Thread
{
    WhiteBoard wb;
    String notes[] = {"Java is laguage","It if Platform","It is OOps","Its suport thread","end"};
    public Teacher(WhiteBoard w){wb=w;}


    @Override
    public void run()
    {
        for(int i=0;i<notes.length;i++)
        {
            wb.write(notes[i]);
        }
    }
}
class WhiteBoard
{
    String text;
    int noOfStudents = 0;
    int count = 0;
    synchronized public void write(String msg)
    {
        System.out.println("Teacher is writing "+msg);
        while (count!=0)
            try{wait();}catch (Exception e){}
        text=msg;
        count = noOfStudents;
        notifyAll();
    }
    synchronized public String read()
    {
        while (count==0)
        {
            try{wait();}catch (Exception e){}
        }
        String t = text;
        count--;
        if(count==0)
            notify();
        return t;

    }
    public void attendance()
    {
        noOfStudents++;
    }
}
class Student extends Thread
{
   String name;
   WhiteBoard wb;
   public Student(String n,WhiteBoard w)
   {
       name = n;
       wb = w;
   }
        @Override
        public void run()
        {
            String text;
            wb.attendance();

            do {
                text = wb.read();
                System.out.println(name +"Reading"+text);
                System.out.flush();
            }while (!text.equals("end"));
       }
}



public class OneProducerMultipalCansumer {
    public static void main(String[] args) {
        WhiteBoard wb = new WhiteBoard();
        Teacher t = new Teacher(wb);
        Student s1 = new Student("Yati",wb);
        Student s2 = new Student("Raj",wb);
        Student s3 = new Student("Parth",wb);
        Student s4 = new Student("Sonu",wb);

        t.start();
        s1.start();
        s2.start();
        s3.start();
        s4.start();

    }
}
