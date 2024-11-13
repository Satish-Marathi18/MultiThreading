package interthread;

public class ProducerConsumerProblem {
    int cnt = -1;
    boolean flag = true;

    public synchronized void Supplier(){

        while(true){
            while(!flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cnt++;
            System.out.println("Suppy: "+cnt);
            flag = false;
            notify();
        }
    }

    public synchronized void Consumer(){
        while(true) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer: " + cnt);
            flag = true;
            notify();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerProblem demo = new ProducerConsumerProblem();
        new Thread(demo::Supplier).start();
        new Thread(demo::Consumer).start();
    }
}
