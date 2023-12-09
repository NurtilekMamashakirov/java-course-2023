package edu.hw9.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import edu.hw9.task1.Metric;
import edu.hw9.task1.StatsCollector;
import edu.hw9.task1.StatsHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatsCollectorTest {

    volatile StatsCollector statsCollector = new StatsCollector();

    @Test
    void pushAndStatsTest() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(() ->
            statsCollector.push("metric1", new double[] {4.0, 7.0, 2.3, 5.4})
        );
        service.execute(() ->
            statsCollector.push("metric2", new double[] {3.4, 9.4, 93.4, 93.3})
        );
        service.execute(() ->
            statsCollector.push("metric3", new double[] {44.3, 79.0, 29.3, 51.42})
        );
        service.execute(() ->
            statsCollector.push("metric4", new double[] {34.0, 192.9, 2.43, 5.43})
        );
        Thread.sleep(100);
        Metric metric1 = service.submit(new StatsHandler("metric1", new double[] {4.0, 7.0, 2.3, 5.4})).get();
        Metric metric2 = service.submit(new StatsHandler("metric2", new double[] {3.4, 9.4, 93.4, 93.3})).get();
        Metric metric3 = service.submit(new StatsHandler("metric3", new double[] {44.3, 79.0, 29.3, 51.42})).get();
        Metric metric4 = service.submit(new StatsHandler("metric4", new double[] {34.0, 192.9, 2.43, 5.43})).get();
        List<Metric> expected = new ArrayList<>();
        expected.add(metric1);
        expected.add(metric2);
        expected.add(metric3);
        expected.add(metric4);
        Assertions.assertThat(expected).containsExactlyInAnyOrderElementsOf(statsCollector.stats());
    }

}
