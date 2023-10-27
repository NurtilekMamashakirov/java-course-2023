package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    private Connection connection;

    private void setConnection() {
        if (Math.random() < 0.5)
            connection = new StableConnection();
        else
            connection = new FaultyConnection();
    }

    @Override
    public Connection getConnection() {
        setConnection();
        return connection;
    }
}
