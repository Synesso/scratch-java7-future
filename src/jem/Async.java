package jem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Async {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public List<Result> process(List<Work> thingsToWorkOn) throws ExecutionException, InterruptedException {
        final List<Future<Result>> futureResults = new ArrayList<>(thingsToWorkOn.size());
        final List<Result> results = new ArrayList<>(thingsToWorkOn.size());

        for (final Work work : thingsToWorkOn) {
            futureResults.add(pool.submit(new Callable<Result>() {
                @Override
                public Result call() throws Exception {
                    return work.work();
                }
            }));
        }

        for (Future<Result> futureResult : futureResults) {
            results.add(futureResult.get());
        }

        return results;
    }
}
