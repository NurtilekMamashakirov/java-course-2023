package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {

    private Connection connection;

    private void setConnection() {
        final double NUMBER_FOR_RANDOM = 0.5;
        if (Math.random() < NUMBER_FOR_RANDOM) {
            connection = new StableConnection();
        } else {
            connection = new FaultyConnection();
        }
    }

    @Override
    public Connection getConnection() {
        setConnection();
        return connection;
    }

}
