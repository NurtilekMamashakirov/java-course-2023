package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Exceptions.ConnectionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

public class PopularCommandExecutorTest {

    static Arguments[] executors() {
        DefaultConnectionManager dManager = Mockito.mock(DefaultConnectionManager.class);
        FaultyConnectionManager fManager = Mockito.mock(FaultyConnectionManager.class);
        FaultyConnection faultyConnection = Mockito.mock(FaultyConnection.class);
        Mockito.doThrow(new ConnectionException()).when(faultyConnection).execute(anyString());
        Mockito.when(dManager.getConnection()).thenReturn(faultyConnection);
        Mockito.when(fManager.getConnection()).thenReturn(faultyConnection);
        return new Arguments[] {
            Arguments.of(dManager),
            Arguments.of(fManager)
        };
    }

    @ParameterizedTest
    @MethodSource("executors")
    void faultyConnectionTest(ConnectionManager connectionManager) {
        PopularCommandExecutor executor = new PopularCommandExecutor(connectionManager, 10);
        assertThrows(ConnectionException.class, executor::updatePackages);
    }
}
