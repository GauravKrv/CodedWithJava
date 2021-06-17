package Mathematics;

import java.util.ArrayList;

public class QuadraticRoots {
    static ArrayList<Integer> calRoots(int a,int b, int c){
       ArrayList<Integer> al = new ArrayList<>();
       long d = (b*b)-(4*a*c);
       // System.out.println("D="+d);
       if (d>=0){
           double x1 = (-b + Math.sqrt(d))/(2*a);
           double x2 = (-b - Math.sqrt(d))/(2*a);

        if(x1>=x2 ) {
               al.add((int) Math.floor(x1));
               al.add((int) Math.floor(x2));
           }else {
            al.add((int) Math.floor(x2));
            al.add((int) Math.floor(x1));
           }

       }else {
           al.add(-1);
       }
       return al;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> al = calRoots(752, 904 ,164);
        ArrayList<Integer> al = calRoots(280, 399 ,573);
      //  System.out.println(al.get(0)+" "+al.get(1));
    }
}