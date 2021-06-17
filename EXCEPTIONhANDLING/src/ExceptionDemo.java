public class ExceptionDemo {

    public static void main(String[] args) {
        //1.Lets generate an error
        int x = 0;
        int y = 10;
        System.out.println("Y/X = "+ y/x);
        System.out.println("End of program");
        /*
        *O/P=> Exception in thread "main" java.lang.ArithmeticException: / by zero
	    at ExceptionDemo.main(ExceptionDemo.java:7)
	    * This output is becoz java is handeling the exception here
	    * No statements will be executed after the exception where it occurs if we left on handleing
	      exception on the java
	    * So this is the problem for not handleing the exception by the user
	    *


        * *  */
    }
}
//2.HAN
 class ExceptionDemo1Handeled {

    public static void main(String[] args) {
   //1.Ans.1.Lets Add a exception handler where we expect the exception to be occured i.e L7
        int x = 0;
        int y = 10;
        try {
            System.out.println("Y/X = " + y / x);
        }
        catch (Exception nameofEx){ //mention the type of excepton to be expected
            //We can also mention "RuntimeException.OR Exception" as Arith ex is part of it.
            //But we cannot give ArrayIndexOutOfBoundsException which is not part of it
            System.out.println("X value should not be zero");
        }

        //This will also execute now
        System.out.println("End of program");
    }
}
class ExceptionDemo1Handeled2 {

    public static void main(String[] args) {
        //1.Ans.2.Lets Add a exception handler where we expect the exception to be occured i.e L7
        int x = 0;
        int y = 10;
        try {
            System.out.println("Y/X = " + y / x);
        }catch (ArithmeticException nameofEx){ //mention the type of excepton to be expected in first place
            //
            //We can also mention "RuntimeException.OR Exception" as Arith ex is part of it.
            //But we cannot give ArrayIndexOutOfBoundsException which is not part of it
            System.out.println("X value should not be zero1");
        }
        catch (RuntimeException nameofEx){
            //We can also mention "RuntimeException" as Arith ex is part of it.
            //But we cannot give it above the Arith exception or below Exception
            System.out.println("X value should not be zero2");
        }
        catch (Exception nameofEx){
            //We can also mention "Exception" as Arith ex is part of it.
            //But we cannot give it above the Arith exception
            System.out.println("X value should not be zero3");

            //Takeaway:->1.We should always place exceptions heirarchicchaly from low to high family
            //Takeaway:->2.It is good to provide more catches as we dont know which exception may occur
            //in whichever line of try block.
        }
        //This will also execute now
        System.out.println("End of program");
    }
}

//
class ExceptionDemo1Handeled3 {

    public static void main(String[] args) {
        //1.Ans3.Lets Add a exception handler where we expect the exception to be occured i.e L7
        int x = 0;
        int y = 10;
        try {

            System.out.println("X value should not be zero00");//This line will execute
            System.out.println("Y/X = " + y / x);

        }
        catch (ArithmeticException nameofEx){
            System.out.println("X value should not be zero1");
        }
        catch (RuntimeException nameofEx){
            System.out.println("X value should not be zero2");
        }
        catch (Exception nameofEx){
            System.out.println("X value should not be zero3");
        }
        finally {
            System.out.println("Inside Finally");
        }
        //We can not be place anything between try - catch block

        //This will also execute now
        System.out.println("End of program");
    }
}
