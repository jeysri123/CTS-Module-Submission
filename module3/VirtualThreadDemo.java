import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadDemo {
    private static final int THREAD_COUNT = 100_000;
    private static final AtomicInteger completedTasks = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("\nRunning with " + THREAD_COUNT + " threads...\n");

        runWithVirtualThreads();
        runWithPlatformThreads();
    }

    private static void runWithVirtualThreads() {
        System.out.println("Testing Virtual Threads:");
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        completedTasks.set(0);
        
        Instant start = Instant.now();
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int taskId = i;
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Virtual Thread " + taskId + " completed");
                    completedTasks.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        
        System.out.println("\nVirtual Threads Results:");
        System.out.println("Time taken: " + duration.toMillis() + "ms");
        System.out.println("Completed tasks: " + completedTasks.get());
        System.out.println("Memory used: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "MB\n");
    }

    private static void runWithPlatformThreads() {
        System.out.println("Testing Platform Threads:");
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        completedTasks.set(0);
        
        Instant start = Instant.now();
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Platform Thread " + taskId + " completed");
                    completedTasks.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        
        System.out.println("\nPlatform Threads Results:");
        System.out.println("Time taken: " + duration.toMillis() + "ms");
        System.out.println("Completed tasks: " + completedTasks.get());
        System.out.println("Memory used: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "MB");
    }
}