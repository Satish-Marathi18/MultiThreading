import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=0; i<5; i++){
            Runnable test = new Test("Test: "+i);
            executor.execute(test);
        }

        executor.shutdown();

        if(executor.isTerminated()){
            System.out.println("All tasks are completed");
        }
    }
}
