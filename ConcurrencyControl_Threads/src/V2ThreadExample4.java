public class V2ThreadExample4 {
///3rd way is to iplement runnable interface as an annonymous class
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                System.out.println("Runnable running");
                System.out.println("Runnable finished");

            }
        };
        Thread t = new Thread(runnable); //this thread class will have
        // the properties of "runnable" only

        t.start();
    }
}



