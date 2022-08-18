public class V2ThreadExample6 {
    //obtaining refrence to currently executing thread
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String tname = Thread.currentThread().getName();// can get the reference of the thread in the main metod
            System.out.println(tname + " is running");
        };

//        Thread t = new Thread(runnable); --> without naming ==: Thread-0
        Thread t = new Thread(runnable, "The threadofEx6"); //naming the thread

        t.start();
    }
}
