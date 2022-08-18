package deadlock;

public class DeadlockPractice {
/*setdaemon : If you call the setDaemon() method after starting of the thread, this method will throw IllegalThreadStateException.*/
/*Daemon threads are low priority threads which always run in background and user threads are high priority threads
    which always run in foreground. User Thread or Non-Daemon are designed to do specific or complex task where as daemon threads are used to perform supporting tasks*/
    public static void main(String[] args) {
        SharedResource s1 = new SharedResource();

        // creating second object
        SharedResource s2 = new SharedResource();

        // creating first thread and starting it
        T1 t1 = new T1(s1, s2);
        t1.setDaemon(true);
        t1.start();

        // creating second thread and starting it
        T2 t2 = new T2(s1, s2);
        t2.start();

        // sleeping main thread
        Util2.sleep(2000);
    }
}
//will make a thread sleep
class Util2{
    static void sleep(long millis) {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
// This class is shared by both threads
class SharedResource {

    //making it synch so that no other thread is able to use this resource since a lock occurs
    synchronized void useresource1(SharedResource s2){
        System.out.println("resource1 - starts being used");
        //now making the curent thread sleep and if it sleeps then it wont be able to free this resource
        Util2.sleep(1000);
        s2.useresource2();//2nd instance will ask for 2nd non-sharable resource
        System.out.println("resource1 - ends being used");
    }

    synchronized void useresource2()
    {
        System.out.println("resource2 - starts being used");
        Util.sleep(1000);
        System.out.println("resource2 - ends being used");

    }
}
//first thread
class T1 extends Thread {
    private SharedResource s1;private SharedResource s2;
    public T1(SharedResource s1, SharedResource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    @Override
    public void run()
    {
        s1.useresource1(s2);
    }
}
//second thread
class T2 extends Thread {
    private SharedResource s1;private SharedResource s2;

    public T2(SharedResource s1, SharedResource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    @Override
    public void run()
    {
        s2.useresource1(s1);
    }
}


