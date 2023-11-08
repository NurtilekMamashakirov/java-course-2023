package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Exceptions.ConnectionException;

public class FaultyConnection implements Connection {

    @Override
    public void execute(String command) {
        if (Math.random() < 0.5) {
            throw new ConnectionException();
        } else {
            System.out.println("Connection executed successfully.");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Connection closed.");
    }

}
