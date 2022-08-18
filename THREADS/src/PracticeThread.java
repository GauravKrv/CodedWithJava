public class PracticeThread {

  public static class NewThread implements Runnable {

        public void run() {
            System.out.println("NewThread Starts");
            for (int i = 0; i < 5; i++) {
                System.out.print(i+" Nt ");
            }
            System.out.println("\n break--NewThread");
            System.out.println("NewThread ends");
        }
    }

    static class Th1 implements Runnable {

        public Th1(Thread t1) {
            t1.start();
        }

        public void run() {
            System.out.println("Th1 Starts");

            for (int i = 0; i < 5; i++) {
                System.out.print(i+" Th1 ");
            }
            System.out.println("\n break--Th1");

            System.out.println("Th1 ends");
        }
    }   static class Th2 implements Runnable {

        public void run() {
            System.out.println("Th2 Starts");

            for (int i = 0; i < 5; i++) {
                System.out.print(i+" Th2 ");
            }
            System.out.println("\n break--Th2");

            System.out.println("Th2 ends");
        }
    }
    public static void main(String[] args) {




        Thread t1 = new Thread(new NewThread());
        t1.start();
        //t2.start();
        Thread t3 = new Thread(new Th2());

        Thread t2 = new Thread(new Th1(t3));

        t2.start();


//setting priority will set the priority that which thread wlll begin first
// BUT not which thread will end first --
// since java is a procedural language so the last priority set (eg if set the priority of same thread 2 times) will be executed
        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);

       // t1.start();//cannot start same thread again



    }
}
