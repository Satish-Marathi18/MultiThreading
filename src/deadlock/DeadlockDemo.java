package deadlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        final Object resource1 = "Resource 1";
        final Object resource2 = "Resource 2";

        Thread thread1 = new Thread(() -> {
            synchronized(resource1) {
                System.out.println("Thread A locked Resorce 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread A Waiting for Resource 2");
                synchronized(resource2){
                    System.out.println("Thread A locked Resource 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized(resource2) {
                System.out.println("Thread B locked Resorce 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("Thread B Waiting for Resource 1");
                synchronized(resource1){
                    System.out.println("Thread A locked Resource 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
