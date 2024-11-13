public class Test implements Runnable {
    private String name;

    public Test(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("Executing test :" +name+ " by "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Completed test :"+name);
    }
}