package AAJava_Concepts;

public class StringOps {

}

class StrEqual {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        if (s1 == s2) {
            System.out.println("s1 and s2 equal");
        } else {
            System.out.println("s1 and s2 not equal");
        }
        if (s1 == s3) {
            System.out.println("s1 and s3 equal");
        } else {
            System.out.println("s1 and s3 not equal");
        }
    }
}

/*
s1 and s2 not equal
s1 and s3 equal
* */
class NullString {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.valueOf(10));
    }
}
//This program will print 10 in the console.

class ConcatString {
    public static void main(String[] args) {
        String s = new String("5");
        System.out.println(1 + 10 + s + 1 + 10);
    }
}
//115110

class AccessNullString {
    public static void main(String[] args) {
        String str = null;
        switch (str) { // #1
            case "null":
                System.out.println("null string"); // #2
                break;
        }
    }
}
//This program results in throwing a NullPointerException.

class TestNull {


    public static void main(String[] args) {
        String s1 = null;
        System.out.println(s1); //line 2
        System.out.println(s1.toString()); //line 3
    }
}
// null NullPointerException

class Intern {

    public static void main(String[] args) {
        String s1 = "Tutorix";
        String s2 = "Tutorix";
        String s3 = new String("Tutorix");
        final String s4 = s3.intern();
        String s5 = "?Tutorix".substring(1);
        String s6 = s5.intern();
        System.out.println(s1 == s2);//t
        System.out.println(s2 == s3);//f
        System.out.println(s3 == s4);//f
        System.out.println(s1 == s3);//f
        System.out.println(s1 == s4);//t
        System.out.println(s1 == s5);//t->f
        System.out.println(s1 == s6);//t
        System.out.println(s1.equals(s2));//rest true
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s4));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s3));
    }
}
//ttrue
//false
//false
//false
//true
//false
//true
//true
//true
//true
//true
//true
/*
The intern() method of the String method returns a canonical representation for the string object.
Using intern() we can save a lot of memory consumed by duplicate string instances.
A string is duplicate if it contains the same content as another string but it
 can be occupied different memory locations.
 For any two strings s and t, s.intern() == t.intern() is true if and only if s.equals(t) is true.
All literal strings and string-valued constant expressions are interned.
* */

class TestStrBuff {

    public static void main(String[] args) {
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));
    }
}
//Every string buffer has a capacity and not string
//false

//DIFF BW STRING BUFFER AND BUILDER
/*
StringBuilder is non-syncronized and thus is not threadsafe whereas StringBuffer is syncronized and threadsafe. But StringBuffer is slow in comparison to StringBuilder because of synchronization overhead.

StringBuffer should be used in the multithreaded environment whereas if only local variables are in scope or thread synchronization is not needed, StringBuilder is preferred.
* */

//TRIMING