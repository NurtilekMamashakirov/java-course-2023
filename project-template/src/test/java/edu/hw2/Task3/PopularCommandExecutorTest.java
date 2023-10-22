package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class PopularCommandExecutorTest {

    static Arguments[] executors() {
        return new Arguments[]{
            Arguments.of(new PopularCommandExecutor(new FaultyConnectionManager(), 10)),
            Arguments.of(new PopularCommandExecutor(new DefaultConnectionManager(), 10))
        };
    }

    @ParameterizedTest
    @MethodSource("executors")
    void faultyConnectionTest(PopularCommandExecutor executor) {
        try {
            executor.tryExecute("cd IdeaProjects/TinkoffProjects");
        } catch (Exception e) {}
    }
}
