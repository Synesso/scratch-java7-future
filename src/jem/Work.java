package jem;

import java.util.Random;

public class Work {
    private final int id;
    public Work(int id) {
        this.id = id;
    }

    public Result work() throws InterruptedException {
        Thread.sleep(Math.abs(new Random().nextLong() % 5000l));
        System.out.println("\"Job's done!\" - peon #" + id);
        return new Result(id);
    }
}
