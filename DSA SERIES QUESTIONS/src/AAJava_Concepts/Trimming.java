package AAJava_Concepts;

public class Trimming {
    /*
    Java trim() is a built-in string method used to remove leading and trailing spaces from a given string. For example, the Unicode value of space “”is ‘\u0020’; this method finds this Unicode value before and end of a string. If this value is found,
    it removes that space and returns the omitting String.
    * */
    //It does not eliminate the middle spaces of the String
    public static void main(String args[])
    {
        String str="   Welcome to Appdividend   ";
        System.out.println("String without trim() is: \n"+str);
        System.out.println("Also the length of the string is: "+str.length());

        String s=str.trim();
        System.out.println("\nString after triming is: \n"+s);
        System.out.println("After triming length of the string: "+s.length());
    }
}


class StringTrimOnlyTrailing {
    public static void main(String args[]) {

        String regex = "\\s+$";

        String kb = "appdividend.com   "; // 3 trailing spaces
        String kl = "   appdividend.com   "; // 3 leading and trailing spaces

        String op1 = kb.replaceAll(regex, "");
        String op2 = kl.replaceAll(regex, "");

        System.out.println(op1);
        System.out.println(op2);
    }
}
