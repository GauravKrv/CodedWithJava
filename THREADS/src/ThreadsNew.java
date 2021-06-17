public class ThreadsNew {
    /*
    1.HEAVYWEIGHT PROCESS AND LIGHT WEIGHT PROCESS
    2.Java Threading
    --Java support multi threading
    --There are two ways to implement multithreading in java
    1]Using thread class
    2]Using Runnable interface[wha is Runnable int]
    whe have to put evereything inside a "run()" method that we
    want to use as thread

    3.Thread Lyfecycle:
    --state1->Newborn state..state1 moves to another state by using
    start() method
    --state 2-.Runnble





    * *  */
}
//we do not put a main method inside a thread
//every thread using class will either extends the Thread class or will implement
//the runnable interface:
//MULTI THREADED PROGRAM DEMO-------------------------------------------------------
//THREAD 1:
class A extends Thread{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread A ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("I = "+i);
            if (i==4) System.out.println("Half of thread A");

        }
        System.out.println("End of thread A ");

    }
}

//THREAD 2:
class B extends Thread{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread B ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("J = "+i);
            if (i==4) System.out.println("Half of thread B");


        }
        System.out.println("End of thread B ");

    }
}

//THREAD 3:
class C extends Thread{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread C ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("K = "+i);
            if (i==4) System.out.println("Half of thread C");


        }
        System.out.println("End of thread C ");

    }
}

//TESTING THREADS
class TestThread{
    public static void main(String[] args) {
        //To use the threads we can create objects for all the threads
        A obj1 = new A();
        B obj2 = new B();
        obj2.setPriority(9);
        Thread t1 = new Thread(obj1);
        t1.setPriority(6);
        //C obj3 = new C();-->Dont want to create obj for C
        obj1.start();
        obj2.start();
        //new A().start();
        new C().start();
    }
}
//OUTPUT WILL BE RANDOM AS THE THEAD WILL BE SCHEDULED BY THE OS



























