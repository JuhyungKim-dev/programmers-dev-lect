
public class task1_4_0618_Main {
    public static void main(String[] args) {
        task1_4_0618_SharedResource resource = new task1_4_0618_SharedResource();
        new task1_4_0618_WorkerThread(resource, "worker1").start();
        new task1_4_0618_WorkerThread(resource, "worker2").start();
        new task1_4_0618_WorkerThread(resource, "worker3").start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    resource.makeResourceAvailable();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }
}