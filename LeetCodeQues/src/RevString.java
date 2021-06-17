import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class RevString {
    public static void main(String[] args) {
        System.out.println("Enter any string");
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        Stack<Character> stChar = new Stack<>();
        for(int i=0;i<st.length();i++)
            stChar.push(st.charAt(i));

        System.out.println("Reversed string is");
        for(int i=0;i<st.length();i++)
            System.out.print(stChar.pop());
    }
    //T.C = O(n), S.C = O(n)  =>Can we do it in S.C = O(n)- yes??
}
class RevStrModif{
    public static void main(String[] args) {
        int s = 0;

         Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to be reversed");
        String aRev = sc.nextLine();
        Vector st= new  Vector(aRev.length());
            for(int i=0;i<aRev.length();i++)
            st.add(aRev.charAt(i));

        //System.out.println("string entered is " +st);

        int e = (st.size() - 1);
       // System.out.println("e = "+e+" s = "+ s);

        while (s<=e){
            //System.out.println("e = "+e+" s = "+ s);
            char temp = (char)st.elementAt(s);
            st.setElementAt(st.elementAt(e),s);
            st.setElementAt(temp,e);

          s++;
          e--;
        }

        //System.out.println("Reversed string is: ");
        for (int j=0;j<st.size();j++)
        System.out.print(st.elementAt(j));
    }
}
