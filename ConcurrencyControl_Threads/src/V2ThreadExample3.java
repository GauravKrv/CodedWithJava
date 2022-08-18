public class V2ThreadExample3 {
        //there are 4 ways to specify what code a thread should run
    //create a class that extends runnable interace
    public static class MyRunnable implements Runnable {
            public void run(){
                System.out.println("MyRunnable running");
                System.out.println("MyRunnable finished");

            }
        }

        public static void main(String[] args) {
            Thread t = new Thread(new MyRunnable());

            t.start();
        }
    }

//3rd way to create an anonymous
//4th way is to create a java lambda expreassion

