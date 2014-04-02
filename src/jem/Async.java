package jem;

import java.util.ArrayList;
import java.util.List;

public class Async {
    public List<Result> process(List<Work> thingsToWorkOn) {
        List<Result> results = new ArrayList<Result>(thingsToWorkOn.size());
        for (Work work : thingsToWorkOn) {
            try {
                work.work();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        return results;
    }
}
