/*
public class MyClassToBook
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++)
        {
          sum+=1;
            System.out.println("Сумма чисел от 1 до 100: " + sum);
        }
    }

 */

    class MyOuter
    {
        int number = 123;

        void show()
        {
            MyInner InnerObj = new MyInner();
            InnerObj.display();
        }

        class MyInner
        {
            void display()
            {
                System.out.println("Поле number = " + number);
            }
        }
    }
        class InnerDemo
        {
            public static void main(String[] args)
            {
                MyOuter OuterObj = new MyOuter();
                OuterObj.show();
            }
        }


