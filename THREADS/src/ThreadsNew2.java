public class ThreadsNew2 {
}
//MULTI THREADED PROGRAM DEMO2 USING RUNNABLE INTERFACE-------------------------------------------------------
//THREAD 1:
class A3 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread A3 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("I = "+i);

        }
        System.out.println("End of thread A3 ");

    }
}

//THREAD 2:
class B3 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread B3 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("J = "+i);

        }
        System.out.println("End of thread B3 ");

    }
}

//THREAD 3:
class C3 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread C3 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("K = "+i);

        }
        System.out.println("End of thread C3 ");

    }
}

//TESTING THREADS
class TestThread2{
    public static void main(String[] args) {
        A3 obj1 = new A3();
        B3 obj2 = new B3();
        //To use start we will require a THREAD object
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(new C3());
        //Now we can use the thread class method "start" using threadd class objects
        t1.start();
        t2.start();
        t3.start();
    }
}
//OUTPUT WILL BE RANDOM AS THE THEAD WILL BE SCHEDULED BY THE OS
//Why I am not able to execute start method using userdefined thread objects(Runnable Inerface)?