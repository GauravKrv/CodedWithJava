package W12StringAndUtilities;

import java.util.*;

public class TryCursors {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("a");
        v.add("b");
        v.add("c");
        v.add("d");
        v.add("g");
        v.add("e");
        v.add("h");
        v.add("f");
        System.out.println(v);

        Enumeration e = v.elements();
        Iterator itr = v.iterator();
        ListIterator litr = v.listIterator();

        System.out.println("1.USING ITERATOR ENUMERATION");
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
            System.out.print(e.nextElement() + "  ");
        }

        System.out.println("2.USING FOR EACH LOOP ==>");
        for (Object obj : v) {//For each String object belongs to this collection books
            System.out.print(obj + " ");
         }

        System.out.println();
        System.out.println("3.USING ITERATOR ==>");

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
            System.out.print(itr.next() + "   ");
        }
       // for ( Object obj2 : itr){ }-->for each loop cant be used with "iterator"
        System.out.println();
        System.out.println("4.USING LIST ITERATOR ==>");
        System.out.println();
       /* while (litr.hasPrevious()) {  ==>NOTING IN PREVIOUS SO WILL NOT PRINT PREVIOUS NOW
            System.out.print(litr.previous() + " ");
            System.out.print(litr.previous() + "   ");
        }*/
        while (litr.hasNext()) {
            System.out.print(litr.next() + " ");
            System.out.print(litr.next() + "   ");
        }
        System.out.println();
        while (litr.hasPrevious()) {
            System.out.print(litr.previous() + " ");
            System.out.print(litr.previous() + "   ");
        }


    }
}
