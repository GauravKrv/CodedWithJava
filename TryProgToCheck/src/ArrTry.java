import java.util.ArrayList;
import java.util.Vector;

public class ArrTry {
    /*public static void main(String[] args) {
        char [] a = new char[0];
        a[0] = 'i';
        System.out.println(a[0]);

        --->GIVES EXCEPTION
    }*/
  /*  public static void main(String[] args) {
        int [] a = new int[20];

        System.out.println(a[10]);
        --GIVES 0
    }*/
/*    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.ensureCapacity(3);//ensures the capacity to be given
        list.trimToSize();//trims the capacity equls curr size
        System.out.println(list.size());
        -->GIVES 2
    }*/
    public static void main(String[] args) {
        Vector list = new Vector();
        list.add("a");
        list.add("b");
        list.capacity();//checks the capacity to be given
        list.trimToSize();//trims the capacity equls curr size
        System.out.println(list.size());
}
}


