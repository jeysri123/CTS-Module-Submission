public class ThreadDemo {
    public static void main(String[] args) {

        MessageThread thread1 = new MessageThread("Thread 1");
        thread1.start();
        
        Thread thread2 = new Thread(new MessageRunnable("Thread 2"));
        thread2.start();
    }
}

class MessageThread extends Thread {
    private String threadName;
    
    public MessageThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": Message " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted!");
            }
        }
    }
}

// Thread class by implementing Runnable
class MessageRunnable implements Runnable {
    private String threadName;
    
    public MessageRunnable(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": Message " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted!");
            }
        }
    }
} 