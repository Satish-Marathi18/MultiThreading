package interthread;

public class InterThreadCommunicationDemo {
    int balance = 1000;

    synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw");
        if(amount > balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance -= amount;
        System.out.println("Withdraw successful");
    }

    synchronized void deposit(int amount) {
        System.out.println("Going to deposit");
        balance += amount;
        System.out.println("Deposit successful");
        notify();
    }

    public static void main(String[] args) {
        InterThreadCommunicationDemo demo = new InterThreadCommunicationDemo();
        Thread t1 = new Thread(() -> demo.withdraw(1500));
        Thread t2 = new Thread(() -> demo.deposit(1000));
        t1.start();
        t2.start();
    }
}
