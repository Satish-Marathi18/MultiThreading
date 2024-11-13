package synchronization;

public class SynchronizationDemo {
    int cnt;

    public synchronized void increment(){
        cnt++;
    }


    public static void main(String[] args) {
        SynchronizationDemo demoOne = new SynchronizationDemo();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                demoOne.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                demoOne.increment();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(demoOne.cnt);
    }
}
