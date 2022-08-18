import static java.lang.Thread.sleep;

public class V2ThreadExample10 {
//OS level threads are heavy -- so we use Project LOOM instead -
    //it is also possible for 1 thread to wait for another thread to terminate by setting another thread as daemon
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread t = new Thread(runnable);
        t.setDaemon(true);
        t.start();
//Now the main thread will continue after the thread t [daemon] is completed its execution
        //thus main thread exits and then jvm shuts down
        try {
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
