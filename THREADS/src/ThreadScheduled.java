public class ThreadScheduled {

    /*
    Thread Priority:
    Default priority of thread is 5 -->normal priority
    10 -->MAX priority
    1-->MIN Priority

    How to know he priority of a thread:
    Using getPriority()

     How to cchange the priority of a thread:
    Using setPriority()
    * * */
}
class A4 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread A4 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("I = "+i);

        }
        System.out.println("End of thread A4 ");

    }
}

//THREAD 2:
class B4 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread B4 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("J = "+i);

        }
        System.out.println("End of thread B4 ");

    }
}

//THREAD 3:
class C4 implements Runnable{
    //every code for a thread must be executed inside the run method
    @Override
    public void run() {
        System.out.println("Start of thread C4 ");
        //Now we can write down whatever operations we need to perform-->
        for(int i =0;i<10;i++){
            System.out.println("K = "+i);

        }
        System.out.println("End of thread C4 ");

    }
}

//TESTING THREADS
class TestThread3{
    public static void main(String[] args) {
        A4 obj1 = new A4();
        B4 obj2 = new B4();
        //To use start we will require a THREAD object
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(new C4());
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(t2.getPriority()+1);
        System.out.println(t2.getPriority());
        t3.setPriority(8);


        //Now we can use the thread class method "start" using threadd class objects

        t3.start();
        t1.start();
        t2.start();


    }
}
