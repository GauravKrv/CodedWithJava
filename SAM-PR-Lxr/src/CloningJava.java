
public class CloningJava implements Cloneable {
    int a ,  b =10;
    static int c = 30;
/*
WHY USE CLONE?
The clone () method is defined in the Object class. Syntax of the clone () method is as follows: Why use clone () method ?
The clone () method saves the extra processing task for creating the exact copy of an object. If we perform it by using the new keyword,
it will take a lot of processing time to be performed that is why we use object cloning.
*
*
* */
    public static void main(String[] args) throws CloneNotSupportedException {
        CloningJava c1 = new CloningJava();
        CloningJava c2 = (CloningJava) (c1).clone();
        CloningJava c3 = c1;
        CloningJava c4 = new CloningJava();

        c1.a =30;
        c1.b = 40;

        //c2.a = 99;
        c3.b = 88;
        System.out.println(c1.a + " "+c1.b);
        System.out.println(c2.a + " "+c2.b);
        System.out.println(c3.a + " "+c3.b);
        System.out.println(c4.a + " "+c4.b);

        /*
        OUTPUT :
30 88
0 10
30 88
0 10
        * */
    }
    // A Java program to demonstrate
// shallow copy using clone()
}

    // An object reference of this class is
// contained by Test2
    class TestMe {
        int x, y;
    }

    // Contains a reference of Test and
// implements clone with shallow copy.
    class TestMeUtil implements Cloneable {
        int a;
        int b;
        TestMe c = new TestMe();
        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    // Driver class
     class Main {
        public static void main(String args[])
                throws CloneNotSupportedException
        {
            TestMeUtil t1 = new TestMeUtil();
            t1.a = 10;
            t1.b = 20;
            t1.c.x = 30;
            t1.c.y = 40;

            TestMeUtil t2 = (TestMeUtil)t1.clone();

            // Creating a copy of object t1
            // and passing it to t2
            t2.a = 100;

            // Change in primitive type of t2 will
            // not be reflected in t1 field
            t2.c.x = 300;

            // Change in object type field will be
            // reflected in both t2 and t1(shallow copy)
            System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                    + " " + t1.c.y);
            System.out.println(t2.a + " " + t2.b + " " + t2.c.x
                    + " " + t2.c.y);
        }
    }


