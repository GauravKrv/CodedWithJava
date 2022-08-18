public class V2ThreadExample8 {
    //Making a thread Sleep
    //again it is not necessary that a thread which wil sleep first will wake up first

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " is running");

            //thread sleep needs to be try-catched
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(tname + " is finished running");
        };



        Thread t1 = new Thread(runnable, "The Thread 1st ");
        t1.start();

        Thread t2 = new Thread(runnable, "The Thread 2nd ");
        t2.start();

        Thread t3 = new Thread(runnable, "The Thread 3rd ");
        t3.start();
    }
}
