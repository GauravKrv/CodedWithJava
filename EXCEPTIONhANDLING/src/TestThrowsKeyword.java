public class TestThrowsKeyword {
    void method1(){
        method2();
        System.out.println("Inside method1()");
    }
    void method2()
    {
        int x = 0;
        int y =0;
        System.out.println(x/y);

    }

    public static void main(String[] args) {
        TestThrowsKeyword obj1 = new TestThrowsKeyword();

            obj1.method1();
            System.out.println("Divide by 0 Exception ");

    }

}//-->Without any exception handlder

//2.Using try catch only.
class TestThrowsKeyword3 {
    void method1(){
        method2();
        System.out.println("Inside method1()");
    }
    void method2()
    {
        int x = 0;
        int y =0;
        System.out.println(x/y);

    }

    public static void main(String[] args) {
        TestThrowsKeyword3 obj1 = new TestThrowsKeyword3();
        try {
            obj1.method1();

        }
        catch (ArithmeticException e){
            System.out.println("Divide by 0 Exception ");
        }
    }

}


//2.USING THROWS KEYWORD WHERE EXCEPTION IS EXPECTED
 class TestThrowsKeyword2 {
    void method1() throws ArithmeticException
    {
        method2();
        System.out.println("Inside method1()");
    }
    void method2() throws ArithmeticException//if we use throws then if we will use this
            //method any where then we will have to use the try catch else will show error
            //MY-To make the programmer know that here an axception will occur so u should beware
    {
        int x = 0;
        int y =0;
        System.out.println(x/y);

    }

    public static void main(String[] args) {
        TestThrowsKeyword2 obj1 = new TestThrowsKeyword2();
        try {
            obj1.method1();

        }
        catch (ArithmeticException e){
            System.out.println("Divide by 0 Exception ");
        }
    }

}
