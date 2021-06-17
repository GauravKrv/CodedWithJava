public class TVariables {
    int x;
    static int z,y;
    void increment(){
        y++;
        x++;
        System.out.println("X= "+x+"Y = "+y+ "Z= "+z);
    }

    public static void main(String[] args) {
        int c =20;
       // this.x = 20;
        TVariables t1 = new TVariables();
        TVariables t2 = new TVariables();
        TVariables t3 = new TVariables();

        t1.increment();
        t2.increment();
        t3.increment();


    }
}
