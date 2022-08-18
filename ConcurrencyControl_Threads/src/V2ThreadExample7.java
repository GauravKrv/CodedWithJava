public class V2ThreadExample7 {

    //running multiple threads -- doesnt guarentee the sequence unless defined
    //obtaining refrence to currently executing thread
    //ORDER OF running the threads is decided by CPU [switching function]
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String tname = Thread.currentThread().getName();// can get the reference of the thread in the main metod
            System.out.println(tname + " is running");
        };
//creating 3 similar threads
        Thread t1 = new Thread(runnable, "The Thread 1st ");
        t1.start(); //this thread class will have the properties of "runnable" only

        Thread t2 = new Thread(runnable, "The Thread 2nd ");
        t2.start();//this thread class will have the properties of "runnable" only

        Thread t3 = new Thread(runnable, "The Thread 3rd ");
        t3.start();//this thread class will have the properties of "runnable" only
    }
}
