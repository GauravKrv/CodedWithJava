package SAP;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        class innerC {
            private String name;
            innerC(String it){
                name = it;

            }


        }
        File[] f = File.listRoots();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }

        int c[] = {1};
       // c[1] = 5;
        Object i = new innerC("Hello");
        innerC ic = (innerC) i;
        System.out.println(ic.name);

        Integer a=10,b=20;
        swap(a,b);
        System.out.println("After swapping : ");
        System.out.println("a="+a);
        System.out.println("b=" +b);
    }

    static void swap(Integer a,Integer b){
        Integer t  = a;
        a=b;
        b=t;
    }
}
