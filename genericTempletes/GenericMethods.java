package genericTempletes;


class MyArrays<T>
{
    T A[] = (T[]) new Object[10];
    int length= 0;
    public void append(T v)
    {
        A[length++] = v;
    }
    public void display()
    {
        for(int i=0;i<length;i++)
        {
            System.out.println(A[i]);
        }
    }
//    T B = (T) new Object();
}

public class GenericMethods {
    static void fun(MyArrays<? extends Number> obj)
    {
        obj.display();
    }

    public static void main(String[] args) {
//        MyArrays<String> ma1= new MyArrays<>();
//        ma1.append("Hi");
//        ma1.append("Bye");

        MyArrays<Integer> ma2 = new MyArrays<>();
        ma2.append(10);
        ma2.append(20);

        //fun(ma1);
        fun(ma2);
    }
}


