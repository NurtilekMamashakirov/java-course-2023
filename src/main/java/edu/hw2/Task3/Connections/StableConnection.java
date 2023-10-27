package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Connections.Connection;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        System.out.println("Connection executed successfully.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Connection closed.");
    }
}
