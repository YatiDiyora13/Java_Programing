package genericTempletes;


class MyArray<T extends Number>
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

public class GenericExample {
    public static void main(String[] args) {
        MyArray<Float> ma= new MyArray<>();

    }
}
