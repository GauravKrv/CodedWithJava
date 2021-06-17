public class ThreadSync {
    public static void main(String[] args) {
       //Prog where i will create multiple thread and execute them
        Reserve res = new Reserve(1);//Want to book one ticket
        Thread t1 = new Thread(res);//Thread-1
        //to check the synchronisation we need minimum of two threads
        Thread t2 = new Thread(res);//Thread-2
        //We can give NAME to a thread and not reference only "res" with the help of setName
        t1.setName("1st");
        t2.setName("2nd");
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
    }
}
//class Reserve extends Thread/ implements Runnable interface
//Always advisable to use runnable interface rather than thread cass

class Reserve implements Runnable
{
    int available = 1;
    int wanted;
Reserve(int no_of_ticket){
    wanted = no_of_ticket;
}
@Override
    public void run() {
        //It is the main part where the threading will be used
    System.out.println("Available Tickets : "+available);//To give an idea to the user about the available no.of tickets
    if (available>=wanted){
        //To get the idea of who is booking current ticket/or which thread is curently running
        String name = Thread.currentThread().getName();
        System.out.println(wanted + " Tickket for "+ name);
        //wait the thrd fo 2000ms so that thred can fill infos in it
        try {
            Thread.sleep(2000);//asusing slee creates n interrupted exception
            //occurs when forcibly stopping a thread with higher priority maybe
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        available = available-wanted;
        System.out.println("Booking Successful!");
    }else {
        System.out.println("Required number of tickets not available");
    }
    }


}

/*
O/P::NO THREAD SYNCRONISATION
Available Tickets : 1
Available Tickets : 1
1 Tickket for 2nd
1 Tickket for 1st
Booking Successful!
Booking Successful!

* * */



