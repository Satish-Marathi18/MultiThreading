package daemonthread;

public class DaemonThreadDemo extends Thread {
    private String name;
    public DaemonThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println(currentThread().getName()+" is a Daemon thread");
        }
        else {
            System.out.println(currentThread().getName()+" is not a Daemon thread");
        }
    }


    public static void main(String[] args) {
        DaemonThreadDemo thread1 = new DaemonThreadDemo("Thread1");
        DaemonThreadDemo thread2 = new DaemonThreadDemo("Thread2");
        DaemonThreadDemo thread3 = new DaemonThreadDemo("Thread3");

        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
