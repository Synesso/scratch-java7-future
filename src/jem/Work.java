package jem;

public class Work {
    public Result work() throws InterruptedException {
        Thread.sleep(5000l);
        System.out.println("Job done!"); // zub zub
        return new Result();
    }
}
