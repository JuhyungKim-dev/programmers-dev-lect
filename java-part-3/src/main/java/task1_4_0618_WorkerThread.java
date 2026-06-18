
class task1_4_0618_WorkerThread extends Thread {

    private task1_4_0618_SharedResource resource;
    private String name;

    public task1_4_0618_WorkerThread(task1_4_0618_SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            resource.waitForResource(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}