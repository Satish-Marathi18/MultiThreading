package deadlock;

public class CloneabaleDemo implements Cloneable {
    String name;
    public CloneabaleDemo(String name){
        this.name=name;
    }

    @Override
    protected CloneabaleDemo clone() throws CloneNotSupportedException {
        return (CloneabaleDemo) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException  {
       CloneabaleDemo demo1 = new CloneabaleDemo("Demo1");
       CloneabaleDemo demo2 = demo1.clone();
       System.out.println(demo2.name);
    }
}
    