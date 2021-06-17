public class ThreadSync2 {
    public static void main(String[] args) {

        Reserve2 res = new Reserve2(1);
        Thread t1 = new Thread(res);//Thread-1
        //to check the synchronisation we need minimum of two threads
        Thread t2 = new Thread(res);//Thread-2
        Thread t3 = new Thread(res);
        Thread t4 = new Thread(res);

        t1.setName("1st");
        t2.setName("2nd");
        t3.setName("3rd");
        t4.setName("4th");
        t1.setPriority(4);
        t2.setPriority(5);
        t3.setPriority(6);
        t4.setPriority(7);
        try {
            t1.start();//if we want t2 to book first then we can start with t2.start(); then t1.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception with "+Thread.currentThread().getName());
            e.printStackTrace();
        }
        try {
            t2.start();//if we want t2 to book first then we can start with t2.start(); then t1.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception with "+Thread.currentThread().getName());
            e.printStackTrace();
        }
        try {
            t3.start();//if we want t2 to book first then we can start with t2.start(); then t1.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception with "+Thread.currentThread().getName());
            e.printStackTrace();
        }
        try {
            t4.start();//if we want t2 to book first then we can start with t2.start(); then t1.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception with "+Thread.currentThread().getName());
            e.printStackTrace();
        }

    }
}

class Reserve2 implements Runnable
{
    int available = 3;
    int wanted;
    Reserve2(int no_of_ticket){
        wanted = no_of_ticket;
    }
    @Override
    public void run() {
        //Using "synchronised" to pass "this or currentThread ->res" and wait the oter threads using res
        synchronized (this) {
            System.out.println("Available Tickets : " + available);
            if (available >= wanted) {

                String name = Thread.currentThread().getName();
                System.out.println(wanted + " Tickket for " + name);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Exception with "+name);
                    e.printStackTrace();
                }
                available = available - wanted;
                System.out.println("Booking Successful!");
            } else {
                System.out.println("Required number of tickets not available for "+Thread.currentThread().getName());
            }
        }
    }


}
/*
We can synchronise A THread either using
1)synchronise(mutual exclusion parameter) block
2)By synchronising an objec i.e res => while one is using res then other thread have to wait

O/P ::Synchronisd output
Available Tickets : 1
1 Ticket for 1st
Booking Successful!
Available Tickets : 0
Required number of tickets not available
*/