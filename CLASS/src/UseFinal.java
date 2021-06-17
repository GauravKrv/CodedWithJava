public class UseFinal extends MyBase {

     final int x=20;

     void display(){
         System.out.println("Hello");
     }
    void show(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        UseFinal uf = new UseFinal();
        System.out.println("X= "+uf.x);
       // uf.x = 21;
        System.out.println(uf.x);
        uf.display();

    }
}
 class MyBase{
    void display(){
        System.out.println("Display Base");
    }
     public static void main(String[] args) {
         UseFinal uf2 = new UseFinal();
         uf2.display();
         uf2.show();
     }
}
