package jem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AsyncTest {

    @Test
    public void shouldNotTakeTooLong() {
        long start = System.currentTimeMillis();
        List<Work> thingsToWorkOn = workItems(10);
        new Async().process(thingsToWorkOn);
        Assert.assertTrue("Dammit, it took too long!", System.currentTimeMillis() - start < 10000L);
    }

    private List<Work> workItems(int i) {
        List<Work> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(new Work());
        }
        return list;
    }
}
