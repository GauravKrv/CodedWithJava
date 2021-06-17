public class Swap {

    public static <T> void swapAny(T x,T y){
        T t;
        t=x;
        x=y;
        y=t;
       // System.out.println("X= "+x+" Y= "+y);
    }

    public static void main(String[] args) {
       String x ="Gaurav";
       String y = "Verma";
        int x2=20;
        int y2 =30;

        System.out.println("X= "+x+" Y= "+y);
        swapAny(x,y);

        System.out.println("X2= "+x+" Y2= "+y);

        swapAny(x2,y2);

    }
}
