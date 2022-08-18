public class V2ThreadExample9 {
    //Implement a runnable that can be stopped -----------------
    //stop a thread in jva -- is better to manage stopping a thread by oursef
    //we should not just call the stop method to stop a thread - but we wont know where the cde our thread has stopped
    //will leave our app in undefined state
        //using thread.setDaemon(true) thread t will be running til the main thread runs
    public static class StoppableRunnable implements Runnable {
        private boolean stopRequested = false;

        public synchronized void setStopRequested(){
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequested;
        }

        private void sleep(long millis){
            try {
                Thread.sleep(millis);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            System.out.println("StoppableRunnable Running");
            while (!isStopRequested()){ //while loop will stop if the setStopRequested function is called at anny time
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("Stoppable Runnable Stopped");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread t = new Thread(stoppableRunnable, "The Thread 1st ");
        t.start();

        try { //mai thread will sleep an not thread 1st
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        System.out.println("requesting stop");
        stoppableRunnable.setStopRequested();
        System.out.println("stop requested");
    }

}
