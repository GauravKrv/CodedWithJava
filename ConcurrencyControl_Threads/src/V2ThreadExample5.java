import java.util.Queue;

public class V2ThreadExample5 {
    //4th way is to create a java lambda expreassion to implement runnable interface

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Lambda running");
            System.out.println("Lambda finished");
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
