public class V2ThreadExample2 {
    //there are 4 ways to specify what code a thread should run
    public static class MyThread extends Thread {
        public void run(){
            System.out.println("Mythread running");
            System.out.println("Mythread finished");

        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread(); //way1 create a thread sub class and over write the run method

        mt.start();
    }
}

//create a class that extends runnable interace
//3rd way to create an anonymous
//4th way is to create a java lambda expreassion
