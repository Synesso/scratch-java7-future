package jem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class AsyncTest {

    @Test
    public void shouldNotTakeTooLong() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Work> thingsToWorkOn = workItems(10);
        List<Result> results = new Async().process(thingsToWorkOn);
        System.out.println("results = " + results);
        assertTrue("Dammit, it took too long!", System.currentTimeMillis() - start < 10000L);
        assertTrue(isInOrder(results));
    }

    private boolean isInOrder(List<Result> results) {
        int r = -1;
        for (Result result : results) {
            if (result.value <= r) {
                return false;
            }
            r = result.value;
        }
        return true;
    }

    private List<Work> workItems(int i) {
        List<Work> list = new ArrayList<>();
        for (int id = 0; id < i; id++) {
            list.add(new Work(id));
        }
        return list;
    }
}
