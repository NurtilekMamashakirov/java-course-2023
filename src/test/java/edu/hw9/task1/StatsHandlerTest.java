package edu.hw9.task1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import edu.hw9.task1.Metric;
import edu.hw9.task1.StatsHandler;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StatsHandlerTest {

    @Test
    void callTest() throws ExecutionException, InterruptedException {
        Metric expected = new Metric("example", 15.0, 5.0, 6.0, 4.0);
        ExecutorService service = Executors.newSingleThreadExecutor();
        StatsHandler statsHandler = new StatsHandler("example", new double[] {4.0, 5.0, 6.0});
        Future<Metric> metricFuture = service.submit(statsHandler);
        Metric metric = metricFuture.get();
        assertThat(metric).isEqualTo(expected);
    }

}
