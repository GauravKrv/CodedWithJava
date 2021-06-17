public class UserDefExcep {
    /*
    ->If i want to handel an exception which is not present in java Exception class
    =>So when we xcreate an exception which cannot be recog by the java then it is caled user
    defined exceoption

   --->Let the user should enter the marls from 0-100, if user enters more than that, then it shows
     error in input, so if we handeled this exception like this then we will create a user defined exeption

    * */
}
//1.Creating a user defined exception class:
//The user defined exception which we will create always extends the Exception class
class InvalidDataException extends Exception{
    /*To display a custom made exception method, two ways are available:
*/
    public InvalidDataException(String msg){
        super(msg);//passing argument to the super class constructor portion

    }
}
//Class for using our user def exception class
class UseException{
    public static void main(String[] args) {
        int mark = -5;
        try {
            mark = -5;
            //whenever w are using user derfined ex we need to generte a condition
            // which may caught that  partcular exception and throws it
            if (mark<0 || mark>100){//Now HERE we are creating our custom exception case in this line,
                // i.e when should our exception occur,
                //if we want to use user defined exception handling then we should use "throw" this ex

                InvalidDataException ide = new InvalidDataException("INVALID DATA PRNT WITHOUT ANONYM OBJ");
                //throw ide;--only one obj can be thrown

                throw new InvalidDataException("INVALID DATA!");

            }else {
                System.out.println("Mark = "+mark);
            }
        }catch (InvalidDataException e){//now whatever will be thrown above in try block
            //will be cathced here by catch block and will be stored here in "e" variable
            System.out.println(e);//will only print the exception and not the line where it occrd
            e.printStackTrace();//WILL PRINT THE LINE WHERE THE EXCEPTION WILL OCCUR
        }
    }

}
