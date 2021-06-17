package NPTLRevision;

import java.util.Scanner;

public class Generics1 <S>{
    S obj;
    S obj2[];

    public Generics1(S obj) {
        this.obj = obj;
    }

    public Generics1(S[] obj2) {
        this.obj2 = obj2;
    }

    void printData(S[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
    public S getObj(){
        return this.obj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Studentx[] s2 = new Studentx[10];



        //Generics1<String> g2 = new Generics1<>("One Twnty seven");
        //System.out.println(g2.getObj());
        for (int i = 1;i<3;i++) {
            System.out.println("Enter Student "+i+" details");
            String sname = sc.next();
            String sbranch = sc.next();
            int sroll = sc.nextInt();
            s2[i] = new Studentx(sname, sbranch, sroll);
        }
        System.out.println("Output : ");

        for (int i = 1;i<3;i++) {

            System.out.println(s2[i]);

        }
       /* for (int i = 1;i<3;i++) {
            System.out.println("Student "+i+" details");
            System.out.println("Name entered = "+s2[i].name);
            System.out.println("Branch = "+s2[i].branch);
            System.out.println();


        }*/




        sc.close();


      /*  Studentx s1 = null;
        for (int i = 1;i<3;i++) {
            System.out.println("Enter Student "+i+" details");
            String sname = sc.next();
            String sbranch = sc.next();
            int sroll = sc.nextInt();
            s1 = new Studentx(sname, sbranch, sroll);
            Generics1<Studentx> sObj = new Generics1<>(s1);
            System.out.println("Name entered = "+sObj.getObj().name);
            System.out.println("Branch = "+sObj.getObj().branch);
            System.out.println();
            s1 = null;
        }
        sc.close();
*/

    }

}

class Studentx{
    int roll;
    String name;
    String branch;

    Studentx(String name,String branch,int roll){
        this.name = name;
        this.branch = branch;
        this.roll = roll;
    }
    public String toString(){
        return this.roll + " " + this.name + " " + this.branch;
    }
}
class TestStudent{
    public static void main(String[] args) {
        Studentx x = new Studentx("Anyone","CSE",000);
        System.out.println(x);
    }
}
